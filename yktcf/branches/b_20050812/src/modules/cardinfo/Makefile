MAKE=make
UNAME=$(shell uname)
LIB = mod_cardinfo.so
CC=g++
TOP=../../..
TOPSRC=../..

ifeq ($(UNAME),SunOS)
CFLAGS = -D_DRTP_V4 -D_MT -DSUNOS -O2 -Wall -D_GDBTEST_ 
APPLIBS=
else
CFLAGS = -D_DRTP_V4 -D_MT -O2 -Wall -D_GDBTEST_ -DDEBUG
APPLIBS = -L$(TOP)/lib/linux  -ldrtplib -lkcrypto -lboost_thread -lbccpub 
endif

LIBS = -lstdc++ -lpthread -ldl

CFLAGS_SHLIB = -fPIC
LDFLAGS_SHLIB =-shared
INCLUDES = -I../../../include

LIB_SHLIB= \
	$(TOPSRC)/*.o
	
OBJS = \
	cardinfo.lo \

all: lib

lib:$(LIB)

$(LIB): $(OBJS)
	$(CC) $(LDFLAGS_SHLIB) -o $(TOP)/modules/$@ $(OBJS) $(LIB_SHLIB) $(APPLIBS)

.SUFFIXES: .o .lo

.c.o:
	$(CC) $(INCLUDES) $(CFLAGS) $<

.c.lo:
	$(CC) -c $(INCLUDES) $(CFLAGS) $(CFLAGS_SHLIB) $< && mv $*.o $*.lo
	

#$(LIB):
#$(CC) $(INCLUDES) $(CFLAGS) $(LDFLAGS_SHLIB) -o $(TOP)/modules/$@ cardinfo.c



.PHONY:clean

clean:
	-rm $(TOP)/modules/$(LIB) *.lo
