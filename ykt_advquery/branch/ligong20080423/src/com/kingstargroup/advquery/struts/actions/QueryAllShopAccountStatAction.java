/**
 * 
 */
package com.kingstargroup.advquery.struts.actions;

import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionServlet;

import com.kingstargroup.advquery.cewolf.CustomerDrawChart;
import com.kingstargroup.advquery.cewolf.DrawBarByTypeMap;
import com.kingstargroup.advquery.cewolf.DrawTimeSeries;
import com.kingstargroup.advquery.common.DateUtil;
import com.kingstargroup.advquery.common.ErrorInfo;
import com.kingstargroup.advquery.common.GetListResultStat;
import com.kingstargroup.advquery.common.GetProperty;
import com.kingstargroup.advquery.common.SortListByResult;
import com.kingstargroup.advquery.reportshopbalance.ReportShopBalanceDAO;

/**
 * �̻������˻��䶯�����Ӫҵ������ѽ��
 * 
 * @author Administrator
 * 
 */
public class QueryAllShopAccountStatAction extends Action {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		QueryAllShopAccountStatActionExecution exec = new QueryAllShopAccountStatActionExecution();
		return exec.execute(mapping,form,request,response);
	}
	private class QueryAllShopAccountStatActionExecution {
		private String beginDate;
		private String endDate;
		private StringBuffer dateRange = new StringBuffer(200);
		private String statTypeShow = "";
		//���ز�ѯ���
		private List weekResult = null;
		private String showType;
		private String picType = "";
		//��λ
		private int dataUnit = 1;
		private int dateUnit = 1;
		private int dataUnit2 = 1;
		//������ʾ��Ϣ
		private String yLabel = "";
		private String yLabel2 = "";
		private String statType ;
		
		//����ͼ��ʱҪ����Ĳ���
		private String accType[] = {"Ӫҵ��","������"};
		private String accType2[] = {"������(�Ŵ�)"};
		private String xData = "";
		private String dataType = "float";
		private String columnTitle[] = {"tradeamt","mngamt"};
		private String columnTitle2[] = {"mngamt"};
		
		// �Զ���ͼ����ʾҪ����Ĳ���
		// ��ʾ�Զ�����ɫ
		private boolean showCustColor = true;
		// ��ʾ���������ֵ���ת����
		private boolean showTextAxis = true;
		// ��ʾBarͼ���ϵ�����
		private boolean showLabel = false;
		// ��ʾ�Զ���ͼ��������ɫ
		private boolean showBackgroundColor = true;
		// ��ʾ������
		private boolean showOutLine = false;
		// ��ʾ������
		private boolean showGrid = true;
		
		ActionServlet servlet = QueryAllShopAccountStatAction.this.servlet;
		public ActionForward execute(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response)
			throws Exception{
			//��ʼ����
			beginDate = request.getParameter("begindate");
			//��������
			endDate = request.getParameter("enddate");
			//ѡ���ͼ����ʾ����
			showType = request.getParameter("showType");		
			
			//ͳ������Ҫ����Ĳ���������ͳ�ƻ�����ͳ�ƣ�
			statType = request.getParameter("statType");
			if (("".equals(beginDate))||("".equals(endDate))){
				request.setAttribute("errorcont",new ErrorInfo().getErrorTip(statType,beginDate,endDate));
				return mapping.findForward("errortest");			
			}
			setInit(request);
			
			List result = new ReportShopBalanceDAO().getShopAccountChangeStat(
					beginDate, endDate,statType);
			if (result.isEmpty()){
				request.setAttribute("errorcont",new ErrorInfo().getErrorTip(statType,beginDate,endDate));
				return mapping.findForward("errortest");			
			}
			//�ж��Ƿ�������ͼ��ʾ
			if (new ErrorInfo().DateRangeJudeg(showType,statType,beginDate,endDate,request)){
				return mapping.findForward("errortest");
			}
			

			dateUnit = result.size()/9;
			setTypeReturn(request,result);
			//����Ҫ��ʾ��ͼ��������ͼ��
			showTypeResult();
			
			request.setAttribute("ylabel",yLabel);
			request.setAttribute("ylabel2",yLabel2);
			request.setAttribute("stattype",statType);
			request.setAttribute("pictype",picType);
			request.setAttribute("showtype",showType);		
			request.setAttribute("daterange",dateRange.toString());
			request.setAttribute("stattypeshow",statTypeShow);
			
			drawPic(request);
			
			return mapping.findForward("allshopaccountstat_queryresult");
			
		}
		/**
		 * ��ʼ��
		 * @param request
		 */
		private void setInit(HttpServletRequest request){
			HttpSession session = request.getSession();
			if ("bydate".equals(statType)){
				beginDate = DateUtil.reFormatTime(request.getParameter("begindate"));
				endDate = DateUtil.reFormatTime(request.getParameter("enddate"));	
	 			session.setAttribute("begindate33d",request.getParameter("begindate"));
				session.setAttribute("enddate33d",request.getParameter("enddate"));
				session.setAttribute("querytype33","0");
				statTypeShow = GetProperty.getProperties("title.date",servlet.getServletContext());
				dateRange.append(GetProperty.getProperties("query.show.date",servlet.getServletContext()))
				.append(beginDate).append("-").append(endDate);
			}else if ("bymonth".equals(statType)){
				beginDate = DateUtil.getMonth(request.getParameter("begindate"));
				endDate = DateUtil.getMonth(request.getParameter("enddate"));
	 			session.setAttribute("begindate33m",request.getParameter("begindate"));
				session.setAttribute("enddate33m",request.getParameter("enddate"));
				session.setAttribute("querytype33","1");
				statTypeShow = GetProperty.getProperties("title.month",servlet.getServletContext());
				dateRange.append(GetProperty.getProperties("query.show.month",servlet.getServletContext()))
				.append(beginDate).append("-").append(endDate);
			}else if ("byweek".equals(statType)){
				beginDate = DateUtil.reFormatTime(request.getParameter("begindate"));
				endDate = DateUtil.reFormatTime(request.getParameter("enddate"));	
	 			session.setAttribute("begindate33w",request.getParameter("begindate"));
				session.setAttribute("enddate33w",request.getParameter("enddate"));
				session.setAttribute("querytype33","2");
				//beginWeek = DateUtilExtend.getWeek(beginDate);
				//endWeek = DateUtilExtend.getWeek(endDate);	
				statTypeShow = GetProperty.getProperties("title.week",servlet.getServletContext());
				dateRange.append(GetProperty.getProperties("query.show.week",servlet.getServletContext()))
				.append(beginDate).append("-").append(endDate);

			}
		}
		private void setTypeReturn (HttpServletRequest request,List result){
			if ("bydate".equals(statType)){
				yLabel = new GetListResultStat().getYLabelMoney(result, "tradeamt",dataType);
				dataUnit = new GetListResultStat().getUnitValue(result, "tradeamt",dataType);
				yLabel2 = new GetListResultStat().getYLabelMoney(result, "mngamt",dataType);
				dataUnit2 = new GetListResultStat().getUnitValue(result, "mngamt",dataType);
				request.setAttribute("result", result);
				xData = "balance_date";
				if ("line".equals(showType)){
					request.setAttribute("allShopAccountStatChart",
					new DrawTimeSeries(result, columnTitle, xData,
							dataType, accType, dataUnit)
							.getTimeSeriesProducer());
					
					request.setAttribute("allShopAccountStatChart2",
							new DrawTimeSeries(result, columnTitle2, xData,
									dataType, accType2, dataUnit2)
									.getTimeSeriesProducer());
					
				}else{
					request.setAttribute("allShopAccountStatChart",
							new DrawBarByTypeMap(result,accType,xData,dataType,columnTitle,dataUnit)
							.getDataProducer());
				}
			}else if ("bymonth".equals(statType)){
				request.setAttribute("result",result);
				yLabel = new GetListResultStat().getYLabelMoney(result,"tradeamt",dataType);
				dataUnit = new GetListResultStat().getUnitValue(result,"tradeamt",dataType);
				xData = "balance_date";
				request.setAttribute("allShopAccountStatChart",new DrawBarByTypeMap(result,accType,xData,dataType,columnTitle,dataUnit).getDataProducer());
				showTextAxis = new ErrorInfo().showTextAxis(result);			
			}else if ("byweek".equals(statType)){
				weekResult = new GetListResultStat().getListByWeek(result,beginDate,endDate);
				Collections.sort(weekResult,new SortListByResult("balance_date"));
				yLabel = new GetListResultStat().getYLabelMoney(weekResult,"tradeamt",dataType);
				dataUnit = new GetListResultStat().getUnitValue(weekResult,"tradeamt",dataType);
				xData = "yearweek";
				request.setAttribute("result",weekResult);
				request.setAttribute("allShopAccountStatChart",
						new DrawBarByTypeMap(weekResult,accType,xData,dataType,columnTitle,dataUnit).getDataProducer());
				showTextAxis = new ErrorInfo().showTextAxis(weekResult);
			}
		}
		/**
		 * ����ѡ���ͼ����������ͼ������
		 *
		 */
		private void showTypeResult(){
			if ("line".equals(showType)) {
				if ("bydate".equals(statType)){
					picType = GetProperty.getProperties("pic.timeseries",servlet.getServletContext());
				}else{
					picType = GetProperty.getProperties("pic.line",servlet.getServletContext());
				}
				showOutLine = false;
			}else if ("bar".equals(showType)){
				picType = GetProperty.getProperties("pic.bar",servlet.getServletContext());
				showOutLine = true;
			}else if ("stack".equals(showType)){
				picType = GetProperty.getProperties("pic.stack",servlet.getServletContext());
				showOutLine = true;
			}
		}
		private void drawPic(HttpServletRequest request){
			if ("line".equals(showType)) {
				if ("bydate".equals(statType)){
					request.setAttribute("dataColor", new CustomerDrawChart(showBackgroundColor,showCustColor,dateUnit)
							.getTimeSeriesPostProcessor());
				}else{
					request.setAttribute("dataColor", new CustomerDrawChart(showCustColor,
							showTextAxis, showLabel, showBackgroundColor, showOutLine,
							showGrid).getChartPostProcessor());
				}
			}else if ("bar".equals(showType)) {
				request.setAttribute("dataColor", new CustomerDrawChart(showCustColor,
						showTextAxis, showLabel, showBackgroundColor, showOutLine,
						showGrid).getChartPostProcessor());
			}else if ("stack".equals(showType)) {
				request.setAttribute("dataColor", new CustomerDrawChart(showCustColor,
						showTextAxis, showLabel, showBackgroundColor, showOutLine,
						showGrid).getChartPostProcessor());
			}
		}
	}
}