// ** I18N

// Calendar DA language
// Author: Michael Thingmand Henriksen, <michael (a) thingmand dot dk>
// Encoding: any
// Distributed under the same terms as the calendar itself.

// For translators: please use UTF-8 if possible. We strongly believe that
// Unicode is the answer to a real internationalized world. Also please
// include your contact information in the header, as can be seen above.

// full day names
Calendar._DN = new Array
("S酶ndag",
"Mandag",
"Tirsdag",
"Onsdag",
"Torsdag",
"Fredag",
"L酶rdag",
"S酶ndag");

// Please note that the following array of short day names (and the same goes
// for short month names, _SMN) isn't absolutely necessary. We give it here
// for exemplification on how one can customize the short day names, but if
// they are simply the first N letters of the full name you can simply say:
//
// Calendar._SDN_len = N; // short day name length
// Calendar._SMN_len = N; // short month name length
//
// If N = 3 then this is not needed either since we assume a value of 3 if not
// present, to be compatible with translation files that were written before
// this feature.

// short day names
Calendar._SDN = new Array
("S酶n",
"Man",
"Tir",
"Ons",
"Tor",
"Fre",
"L酶r",
"S酶n");

// full month names
Calendar._MN = new Array
("Januar",
"Februar",
"Marts",
"April",
"Maj",
"Juni",
"Juli",
"August",
"September",
"Oktober",
"November",
"December");

// short month names
Calendar._SMN = new Array
("Jan",
"Feb",
"Mar",
"Apr",
"Maj",
"Jun",
"Jul",
"Aug",
"Sep",
"Okt",
"Nov",
"Dec");

// tooltips
Calendar._TT = {};
Calendar._TT["INFO"] = "Om Kalenderen";

Calendar._TT["ABOUT"] =
"DHTML Date/Time Selector\n" +
"(c) dynarch.com 2002-2005 / Author: Mihai Bazon\n" + // don't translate this this ;-)
"For den seneste version bes酶g: http://www.dynarch.com/projects/calendar/\n"; +
"Distribueret under GNU LGPL. Se http://gnu.org/licenses/lgpl.html for detajler." +
"\n\n" +
"Valg af dato:\n" +
"- Brug \xab, \xbb knapperne for at v忙lge 氓r\n" +
"- Brug " + String.fromCharCode(0x2039) + ", " + String.fromCharCode(0x203a) + " knapperne for at v忙lge m氓ned\n" +
"- Hold knappen p氓 musen nede p氓 knapperne ovenfor for hurtigere valg.";
Calendar._TT["ABOUT_TIME"] = "\n\n" +
"Valg af tid:\n" +
"- Klik p氓 en vilk氓rlig del for st酶rre v忙rdi\n" +
"- eller Shift-klik for for mindre v忙rdi\n" +
"- eller klik og tr忙k for hurtigere valg.";

Calendar._TT["PREV_YEAR"] = "脡t 氓r tilbage (hold for menu)";
Calendar._TT["PREV_MONTH"] = "脡n m氓ned tilbage (hold for menu)";
Calendar._TT["GO_TODAY"] = "G氓 til i dag";
Calendar._TT["NEXT_MONTH"] = "脡n m氓ned frem (hold for menu)";
Calendar._TT["NEXT_YEAR"] = "脡t 氓r frem (hold for menu)";
Calendar._TT["SEL_DATE"] = "V忙lg dag";
Calendar._TT["DRAG_TO_MOVE"] = "Tr忙k vinduet";
Calendar._TT["PART_TODAY"] = " (i dag)";

// the following is to inform that "%s" is to be the first day of week
// %s will be replaced with the day name.
Calendar._TT["DAY_FIRST"] = "Vis %s f酶rst";

// This may be locale-dependent. It specifies the week-end days, as an array
// of comma-separated numbers. The numbers are from 0 to 6: 0 means Sunday, 1
// means Monday, etc.
Calendar._TT["WEEKEND"] = "0,6";

Calendar._TT["CLOSE"] = "Luk";
Calendar._TT["TODAY"] = "I dag";
Calendar._TT["TIME_PART"] = "(Shift-)klik eller tr忙k for at 忙ndre v忙rdi";

// date formats
Calendar._TT["DEF_DATE_FORMAT"] = "%d-%m-%Y";
Calendar._TT["TT_DATE_FORMAT"] = "%a, %b %e";

Calendar._TT["WK"] = "Uge";
Calendar._TT["TIME"] = "Tid:";
