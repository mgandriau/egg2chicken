package mg.egg.eggc.compiler.egg.java;
import mg.egg.eggc.runtime.libjava.lex.*;

public class JLEX_EGG implements  LEX_ANALYZER  {
	private final int YY_BUFFER_SIZE = 512;
	private final int YY_F = -1;
	private final int YY_NO_STATE = -1;
	private final int YY_NOT_ACCEPT = 0;
	private final int YY_START = 1;
	private final int YY_END = 2;
	private final int YY_NO_ANCHOR = 4;
	private final int YY_BOL = 256;
	private final int YY_EOF = 257;

	private java.io.BufferedReader yy_reader;
	private int yy_buffer_index;
	private int yy_buffer_read;
	private int yy_buffer_start;
	private int yy_buffer_end;
	private char yy_buffer[];
	private int yychar;
	private int yyline;
	private boolean yy_at_bol;
	private int yy_lexical_state;

	public JLEX_EGG (java.io.Reader reader) {
		this ();
		if (null == reader) {
			throw (new Error("Error: Bad input stream initializer."));
		}
		yy_reader = new java.io.BufferedReader(reader);
	}

	public JLEX_EGG (java.io.InputStream instream) {
		this ();
		if (null == instream) {
			throw (new Error("Error: Bad input stream initializer."));
		}
		yy_reader = new java.io.BufferedReader(new java.io.InputStreamReader(instream));
	}

	public JLEX_EGG () {
		yy_buffer = new char[YY_BUFFER_SIZE];
		yy_buffer_read = 0;
		yy_buffer_index = 0;
		yy_buffer_start = 0;
		yy_buffer_end = 0;
		yychar = 0;
		yyline = 0;
		yy_at_bol = true;
		yy_lexical_state = YYINITIAL;
	}

	public void fromContext(LEX_CONTEXTE cont) {
		yy_reader = cont.source;
		yy_buffer = cont.buffer;
		yy_buffer_read = cont.b_read;
		yy_buffer_index = cont.b_index;
		yy_buffer_start = cont.b_start;
		yy_buffer_end = cont.b_end;
		yychar = cont.car;
		yyline = cont.ligne;
		yy_at_bol = true;
		yy_lexical_state = YYINITIAL;
	}
	public void toContext(LEX_CONTEXTE cont) {		cont.source = yy_reader;
		cont.buffer = yy_buffer;
		cont.b_read = yy_buffer_read;
		cont.b_index = yy_buffer_index;
		cont.b_start = yy_buffer_start;
		cont.b_end = yy_buffer_end;
		cont.ligne = yyline;
		cont.car = yychar;
	}
	public void setReader(java.io.BufferedReader r) {
		yy_reader = r;
	}
	private boolean yy_eof_done = false;
	private final int YYINITIAL = 0;
	private final int yy_state_dtrans[] = {
		0
	};
	private void yybegin (int state) {
		yy_lexical_state = state;
	}
	private int yy_advance ()
		throws java.io.IOException {
		int next_read;
		int i;
		int j;

		if (yy_buffer_index < yy_buffer_read) {
			return yy_buffer[yy_buffer_index++];
		}

		if (0 != yy_buffer_start) {
			i = yy_buffer_start;
			j = 0;
			while (i < yy_buffer_read) {
				yy_buffer[j] = yy_buffer[i];
				++i;
				++j;
			}
			yy_buffer_end = yy_buffer_end - yy_buffer_start;
			yy_buffer_start = 0;
			yy_buffer_read = j;
			yy_buffer_index = j;
			next_read = yy_reader.read(yy_buffer,
					yy_buffer_read,
					yy_buffer.length - yy_buffer_read);
			if (-1 == next_read) {
				return YY_EOF;
			}
			yy_buffer_read = yy_buffer_read + next_read;
		}

		while (yy_buffer_index >= yy_buffer_read) {
			if (yy_buffer_index >= yy_buffer.length) {
				yy_buffer = yy_double(yy_buffer);
			}
			next_read = yy_reader.read(yy_buffer,
					yy_buffer_read,
					yy_buffer.length - yy_buffer_read);
			if (-1 == next_read) {
				return YY_EOF;
			}
			yy_buffer_read = yy_buffer_read + next_read;
		}
		return yy_buffer[yy_buffer_index++];
	}
	private void yy_move_end () {
		if (yy_buffer_end > yy_buffer_start &&
			'\n' == yy_buffer[yy_buffer_end-1])
			yy_buffer_end--;
		if (yy_buffer_end > yy_buffer_start &&
			'\r' == yy_buffer[yy_buffer_end-1])
			yy_buffer_end--;
	}
	private boolean yy_last_was_cr=false;
	private void yy_mark_start () {
		int i;
		for (i = yy_buffer_start; i < yy_buffer_index; ++i) {
			if ('\n' == yy_buffer[i] && !yy_last_was_cr) {
				++yyline;
			}
			if ('\r' == yy_buffer[i]) {
				++yyline;
				yy_last_was_cr=true;
			} else yy_last_was_cr=false;
		}
		yychar = yychar
			+ yy_buffer_index - yy_buffer_start;
		yy_buffer_start = yy_buffer_index;
	}
	private void yy_mark_end () {
		yy_buffer_end = yy_buffer_index;
	}
	private void yy_to_mark () {
		yy_buffer_index = yy_buffer_end;
		yy_at_bol = (yy_buffer_end > yy_buffer_start) &&
			        ('\r' == yy_buffer[yy_buffer_end-1] ||
			         '\n' == yy_buffer[yy_buffer_end-1] ||
			         2028/*LS*/ == yy_buffer[yy_buffer_end-1] ||
			         2029/*PS*/ == yy_buffer[yy_buffer_end-1]);
	}
	private java.lang.String yytext () {
		return (new java.lang.String(yy_buffer,
			yy_buffer_start,
			yy_buffer_end - yy_buffer_start));
	}
	private int yylength () {
		return yy_buffer_end - yy_buffer_start;
	}
	private char[] yy_double (char buf[]) {
		int i;
		char newbuf[];
		newbuf = new char[2*buf.length];
		for (i = 0; i < buf.length; ++i) {
			newbuf[i] = buf[i];
		}
		return newbuf;
	}
	private final int YY_E_INTERNAL = 0;
	private final int YY_E_MATCH = 1;
	private java.lang.String yy_error_string[] = {
		"Error: Internal error.\n",
		"Error: Unmatched input.\n"
	};
	private void yy_error (int code,boolean fatal) {
		java.lang.System.out.print(yy_error_string[code]);
		java.lang.System.out.flush();
		if (fatal) {
			throw new Error("Fatal Error.\n");
		}
	}
	private int[][] unpackFromString(int size1, int size2, String st) {
		int colonIndex = -1;
		String lengthString;
		int sequenceLength = 0;
		int sequenceInteger = 0;

		int commaIndex;
		String workString;

		int res[][] = new int[size1][size2];
		for (int i= 0; i < size1; i++) {
			for (int j= 0; j < size2; j++) {
				if (sequenceLength != 0) {
					res[i][j] = sequenceInteger;
					sequenceLength--;
					continue;
				}
				commaIndex = st.indexOf(',');
				workString = (commaIndex==-1) ? st :
					st.substring(0, commaIndex);
				st = st.substring(commaIndex+1);
				colonIndex = workString.indexOf(':');
				if (colonIndex == -1) {
					res[i][j]=Integer.parseInt(workString);
					continue;
				}
				lengthString =
					workString.substring(colonIndex+1);
				sequenceLength=Integer.parseInt(lengthString);
				workString=workString.substring(0,colonIndex);
				sequenceInteger=Integer.parseInt(workString);
				res[i][j] = sequenceInteger;
				sequenceLength--;
			}
		}
		return res;
	}
	private int yy_acpt[] = {
		/* 0 */ YY_NOT_ACCEPT,
		/* 1 */ YY_NO_ANCHOR,
		/* 2 */ YY_NO_ANCHOR,
		/* 3 */ YY_NO_ANCHOR,
		/* 4 */ YY_NO_ANCHOR,
		/* 5 */ YY_NO_ANCHOR,
		/* 6 */ YY_NO_ANCHOR,
		/* 7 */ YY_NO_ANCHOR,
		/* 8 */ YY_NO_ANCHOR,
		/* 9 */ YY_NO_ANCHOR,
		/* 10 */ YY_NO_ANCHOR,
		/* 11 */ YY_NO_ANCHOR,
		/* 12 */ YY_NO_ANCHOR,
		/* 13 */ YY_NO_ANCHOR,
		/* 14 */ YY_NO_ANCHOR,
		/* 15 */ YY_NO_ANCHOR,
		/* 16 */ YY_NO_ANCHOR,
		/* 17 */ YY_NO_ANCHOR,
		/* 18 */ YY_NO_ANCHOR,
		/* 19 */ YY_NO_ANCHOR,
		/* 20 */ YY_NO_ANCHOR,
		/* 21 */ YY_NO_ANCHOR,
		/* 22 */ YY_NO_ANCHOR,
		/* 23 */ YY_NO_ANCHOR,
		/* 24 */ YY_NO_ANCHOR,
		/* 25 */ YY_NO_ANCHOR,
		/* 26 */ YY_NO_ANCHOR,
		/* 27 */ YY_NO_ANCHOR,
		/* 28 */ YY_NO_ANCHOR,
		/* 29 */ YY_NO_ANCHOR,
		/* 30 */ YY_NO_ANCHOR,
		/* 31 */ YY_NO_ANCHOR,
		/* 32 */ YY_NO_ANCHOR,
		/* 33 */ YY_NO_ANCHOR,
		/* 34 */ YY_NO_ANCHOR,
		/* 35 */ YY_NO_ANCHOR,
		/* 36 */ YY_NO_ANCHOR,
		/* 37 */ YY_NO_ANCHOR,
		/* 38 */ YY_NOT_ACCEPT,
		/* 39 */ YY_NO_ANCHOR,
		/* 40 */ YY_NO_ANCHOR,
		/* 41 */ YY_NOT_ACCEPT,
		/* 42 */ YY_NO_ANCHOR,
		/* 43 */ YY_NO_ANCHOR,
		/* 44 */ YY_NOT_ACCEPT,
		/* 45 */ YY_NO_ANCHOR,
		/* 46 */ YY_NO_ANCHOR,
		/* 47 */ YY_NOT_ACCEPT,
		/* 48 */ YY_NO_ANCHOR,
		/* 49 */ YY_NO_ANCHOR,
		/* 50 */ YY_NO_ANCHOR,
		/* 51 */ YY_NO_ANCHOR,
		/* 52 */ YY_NO_ANCHOR,
		/* 53 */ YY_NO_ANCHOR,
		/* 54 */ YY_NO_ANCHOR,
		/* 55 */ YY_NO_ANCHOR,
		/* 56 */ YY_NO_ANCHOR,
		/* 57 */ YY_NO_ANCHOR,
		/* 58 */ YY_NO_ANCHOR,
		/* 59 */ YY_NO_ANCHOR,
		/* 60 */ YY_NO_ANCHOR,
		/* 61 */ YY_NO_ANCHOR,
		/* 62 */ YY_NO_ANCHOR,
		/* 63 */ YY_NO_ANCHOR,
		/* 64 */ YY_NO_ANCHOR,
		/* 65 */ YY_NO_ANCHOR,
		/* 66 */ YY_NO_ANCHOR,
		/* 67 */ YY_NO_ANCHOR,
		/* 68 */ YY_NO_ANCHOR,
		/* 69 */ YY_NO_ANCHOR,
		/* 70 */ YY_NO_ANCHOR,
		/* 71 */ YY_NO_ANCHOR,
		/* 72 */ YY_NO_ANCHOR,
		/* 73 */ YY_NO_ANCHOR,
		/* 74 */ YY_NO_ANCHOR,
		/* 75 */ YY_NO_ANCHOR,
		/* 76 */ YY_NO_ANCHOR,
		/* 77 */ YY_NO_ANCHOR,
		/* 78 */ YY_NO_ANCHOR,
		/* 79 */ YY_NO_ANCHOR,
		/* 80 */ YY_NO_ANCHOR,
		/* 81 */ YY_NO_ANCHOR,
		/* 82 */ YY_NO_ANCHOR,
		/* 83 */ YY_NO_ANCHOR,
		/* 84 */ YY_NO_ANCHOR,
		/* 85 */ YY_NO_ANCHOR,
		/* 86 */ YY_NO_ANCHOR,
		/* 87 */ YY_NO_ANCHOR,
		/* 88 */ YY_NO_ANCHOR,
		/* 89 */ YY_NO_ANCHOR,
		/* 90 */ YY_NO_ANCHOR,
		/* 91 */ YY_NO_ANCHOR,
		/* 92 */ YY_NO_ANCHOR,
		/* 93 */ YY_NO_ANCHOR,
		/* 94 */ YY_NO_ANCHOR,
		/* 95 */ YY_NO_ANCHOR,
		/* 96 */ YY_NO_ANCHOR,
		/* 97 */ YY_NO_ANCHOR,
		/* 98 */ YY_NO_ANCHOR,
		/* 99 */ YY_NO_ANCHOR,
		/* 100 */ YY_NO_ANCHOR,
		/* 101 */ YY_NO_ANCHOR,
		/* 102 */ YY_NO_ANCHOR,
		/* 103 */ YY_NO_ANCHOR,
		/* 104 */ YY_NO_ANCHOR,
		/* 105 */ YY_NO_ANCHOR,
		/* 106 */ YY_NO_ANCHOR,
		/* 107 */ YY_NO_ANCHOR,
		/* 108 */ YY_NO_ANCHOR,
		/* 109 */ YY_NO_ANCHOR
	};
	private int yy_cmap[] = unpackFromString(1,258,
"3:9,4,1,3:2,4,3:18,4,3,33,51,54,3:5,5,3,21,2,3:2,52:10,13,22,23,3,24,3:2,50" +",46,48,43,42,53,41,49,39,53:2,47,53,40,44,53:2,38,36,37,45,53:5,16,3,17,3,5" +"2,3,11,35,27,34,28,18,31,8,6,53,12,32,29,7,19,25,53,20,9,26,30,53:3,10,53,1" +"4,3,15,3:130,0:2")[0];

	private int yy_rmap[] = unpackFromString(1,110,
"0,1,2,3,4,1:11,5,6,1,5:5,1:2,5:12,7,1,5,8,6,9,10,11,12,13,14,15,16,17,18,19" +",20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44" +",45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60,61,62,63,64,65,66,67,68,69" +",70,71,72,73,74,75")[0];

	private int yy_nxt[][] = unpackFromString(76,55,
"1,2,3,39,2,39,4,40:2,63,40,64,40,5,6,7,8,9,65,99,40,10,11,12,13,40,79,100,6" +"6,91,40,101,40,14,40:2,102,40:2,106,40:3,103,40:4,109,40:2,42,39,40,45,-1:5" +"6,2,-1:2,2,-1:52,38,-1:2,41,-1:18,15,-1:36,40,43,40,16,40:3,-1:5,40:3,-1:4," +"40:8,-1,40:17,-1,40:2,-1:7,40:7,-1:5,40:3,-1:4,40:8,-1,40:17,-1,40:2,-1:7,1" +"7:7,-1:5,17:3,-1:4,17:8,-1,17:17,-1,17:2,-1:2,18,38:53,-1,41:4,47,41:49,-1:" +"6,40:2,19,40:4,-1:5,40:3,-1:4,40:8,-1,40:17,-1,40:2,-1:2,44:53,24,-1,44:53," +"-1:7,40,20,40:5,-1:5,40:3,-1:4,40:8,-1,40:17,-1,40:2,-1:2,41,25,41:2,47,41:" +"49,-1:6,40:5,21,40,-1:5,40:3,-1:4,40:8,-1,40:17,-1,40:2,-1:7,40:7,-1:5,40:2" +",22,-1:4,40:8,-1,40:17,-1,40:2,-1:7,40:7,-1:5,40:3,-1:4,40:8,-1,23,40:16,-1" +",40:2,-1:7,40:7,-1:5,40:3,-1:4,40:4,26,40:3,-1,40:17,-1,40:2,-1:7,40:7,-1:5" +",40:3,-1:4,40:3,27,40:4,-1,40:17,-1,40:2,-1:7,40:7,-1:5,40:2,28,-1:4,40:8,-" +"1,40:17,-1,40:2,-1:7,40:7,-1:5,40,29,40,-1:4,40:8,-1,40:17,-1,40:2,-1:7,40," +"30,40:5,-1:5,40:3,-1:4,40:8,-1,40:17,-1,40:2,-1:7,40:7,-1:5,40:3,-1:4,40:7," +"31,-1,40:17,-1,40:2,-1:7,40:7,-1:5,40:3,-1:4,40:7,32,-1,40:17,-1,40:2,-1:7," +"40:7,-1:5,40:3,-1:4,40:8,-1,40:7,33,40:9,-1,40:2,-1:7,40:7,-1:5,40:3,-1:4,4" +"0:8,-1,40:8,34,40:8,-1,40:2,-1:7,40:7,-1:5,40:3,-1:4,40,35,40:6,-1,40:17,-1" +",40:2,-1:7,40:7,-1:5,40:3,-1:4,40:8,-1,40:4,36,40:12,-1,40:2,-1:7,40:7,-1:5" +",40:3,-1:4,40:8,-1,40:4,37,40:12,-1,40:2,-1:7,40:4,46,40:2,-1:5,40:3,-1:4,8" +"0,40:4,81,40:2,-1,40:17,-1,40:2,-1:7,40:6,48,-1:5,40:3,-1:4,40:8,-1,40:17,-" +"1,40:2,-1:7,40:7,-1:5,40,49,40,-1:4,40:8,-1,40:17,-1,40:2,-1:7,40,50,40:5,-" +"1:5,40:3,-1:4,40:8,-1,40:17,-1,40:2,-1:7,40:7,-1:5,40:2,51,-1:4,40:8,-1,40:" +"17,-1,40:2,-1:7,40:7,-1:5,40:3,-1:4,40:2,52,40:5,-1,40:17,-1,40:2,-1:7,40:5" +",53,40,-1:5,40:3,-1:4,40:8,-1,40:17,-1,40:2,-1:7,40:7,-1:5,40:2,54,-1:4,40:" +"8,-1,40:17,-1,40:2,-1:7,40:7,-1:5,40,55,40,-1:4,40:8,-1,40:17,-1,40:2,-1:7," +"56,40:6,-1:5,40:3,-1:4,40:8,-1,40:17,-1,40:2,-1:7,40:5,57,40,-1:5,40:3,-1:4" +",40:8,-1,40:17,-1,40:2,-1:7,40:7,-1:5,40:3,-1:4,40:8,-1,40:6,58,40:10,-1,40" +":2,-1:7,40:7,-1:5,40:3,-1:4,40:8,-1,40:13,59,40:3,-1,40:2,-1:7,40,60,40:5,-" +"1:5,40:3,-1:4,40:8,-1,40:17,-1,40:2,-1:7,40:7,-1:5,40:3,-1:4,40:8,-1,40:8,6" +"1,40:8,-1,40:2,-1:7,40:7,-1:5,40:3,-1:4,40:8,-1,40:8,62,40:8,-1,40:2,-1:7,4" +"0:7,-1:5,40:3,-1:4,40:3,67,40:4,-1,40:17,-1,40:2,-1:7,40:5,68,40,-1:5,40:3," +"-1:4,40:8,-1,40:17,-1,40:2,-1:7,40:7,-1:5,40:3,-1:4,40:6,69,40,-1,40:17,-1," +"40:2,-1:7,40:7,-1:5,40:3,-1:4,40:2,70,40:5,-1,40:17,-1,40:2,-1:7,71,40:6,-1" +":5,40:3,-1:4,40:8,-1,40:17,-1,40:2,-1:7,40:7,-1:5,40:3,-1:4,72,40:3,88,40:3" +",-1,40:17,-1,40:2,-1:7,40:7,-1:5,40:3,-1:4,40:8,-1,40,73,40:15,-1,40:2,-1:7" +",40:7,-1:5,40:3,-1:4,40:8,-1,40:5,74,40:11,-1,40:2,-1:7,40:7,-1:5,40:3,-1:4" +",40:8,-1,40:12,75,40:4,-1,40:2,-1:7,40:7,-1:5,40:3,-1:4,40:3,76,40:4,-1,40:" +"17,-1,40:2,-1:7,40:7,-1:5,40:3,-1:4,40:8,-1,40:7,77,40:9,-1,40:2,-1:7,40:7," +"-1:5,40:3,-1:4,40:8,-1,40:3,78,40:13,-1,40:2,-1:7,40:5,82,40,-1:5,40:3,-1:4" +",40:8,-1,40:17,-1,40:2,-1:7,40:7,-1:5,40:3,-1:4,40,83,40:6,-1,40:17,-1,40:2" +",-1:7,40:7,-1:5,40:3,-1:4,40:4,84,40:3,-1,40:17,-1,40:2,-1:7,40:7,-1:5,40,8" +"5,40,-1:4,40:8,-1,40:17,-1,40:2,-1:7,40:7,-1:5,40:3,-1:4,40:8,-1,40:4,86,40" +":12,-1,40:2,-1:7,40:7,-1:5,40:3,-1:4,40:8,-1,40:11,87,40:5,-1,40:2,-1:7,40:" +"7,-1:5,40:3,-1:4,40:8,-1,40:8,89,40:8,-1,40:2,-1:7,40:7,-1:5,40:3,-1:4,40:8" +",-1,40:14,90,40:2,-1,40:2,-1:7,40:7,-1:5,40:3,-1:4,92,40:7,-1,40:17,-1,40:2" +",-1:7,40:7,-1:5,40,93,40,-1:4,40:8,-1,40:17,-1,40:2,-1:7,40:7,-1:5,40:3,-1:" +"4,40:7,94,-1,40:17,-1,40:2,-1:7,40:7,-1:5,40:3,-1:4,40:8,-1,40:3,95,40:13,-" +"1,40:2,-1:7,40:7,-1:5,40:3,-1:4,40:8,-1,40:10,96,40:6,-1,40:2,-1:7,40:7,-1:" +"5,40:3,-1:4,40:8,-1,40:3,97,40:13,-1,40:2,-1:7,40:7,-1:5,40:3,-1:4,40:8,-1," +"40:16,98,-1,40:2,-1:7,40:7,-1:5,40:3,-1:4,40:8,-1,40:6,104,40:10,-1,40:2,-1" +":7,40:7,-1:5,40:3,-1:4,40:8,-1,40:4,105,40:12,-1,40:2,-1:7,40:7,-1:5,40:3,-" +"1:4,40:8,-1,40:16,107,-1,40:2,-1:7,40:7,-1:5,40:3,-1:4,40:8,-1,40:15,108,40" +",-1,40:2,-1");

	public Yytoken yylex ()
		throws java.io.IOException {
		int yy_lookahead;
		int yy_anchor = YY_NO_ANCHOR;
		int yy_state = yy_state_dtrans[yy_lexical_state];
		int yy_next_state = YY_NO_STATE;
		int yy_last_accept_state = YY_NO_STATE;
		boolean yy_initial = true;
		int yy_this_accept;

		yy_mark_start();
		yy_this_accept = yy_acpt[yy_state];
		if (YY_NOT_ACCEPT != yy_this_accept) {
			yy_last_accept_state = yy_state;
			yy_mark_end();
		}
		while (true) {
			if (yy_initial && yy_at_bol) yy_lookahead = YY_BOL;
			else yy_lookahead = yy_advance();
			yy_next_state = YY_F;
			yy_next_state = yy_nxt[yy_rmap[yy_state]][yy_cmap[yy_lookahead]];
			if (YY_EOF == yy_lookahead && true == yy_initial) {

	return new Yytoken(LEX_EGG.EOF , "EOF" , yyline , yychar , yychar+1 ) ;
			}
			if (YY_F != yy_next_state) {
				yy_state = yy_next_state;
				yy_initial = false;
				yy_this_accept = yy_acpt[yy_state];
				if (YY_NOT_ACCEPT != yy_this_accept) {
					yy_last_accept_state = yy_state;
					yy_mark_end();
				}
			}
			else {
				if (YY_NO_STATE == yy_last_accept_state) {
					throw (new Error("Lexical Error: Unmatched Input."));
				}
				else {
					yy_anchor = yy_acpt[yy_last_accept_state];
					if (0 != (YY_END & yy_anchor)) {
						yy_move_end();
					}
					yy_to_mark();
					switch (yy_last_accept_state) {
					
case 1:
					
	
					
case -2:
					
	break;
					
case 2:
					
	{return new Yytoken(LEX_EGG.token_separateurs, yytext(), yyline, yychar, yychar+1);}
					
case -3:
					
	break;
					
case 3:
					
	{return new Yytoken(LEX_EGG.token_autre, yytext(), yyline, yychar, yychar+1);}
					
case -4:
					
	break;
					
case 4:
					
	{return new Yytoken(LEX_EGG.token_t_ident, yytext(), yyline, yychar, yychar+1);}
					
case -5:
					
	break;
					
case 5:
					
	{return new Yytoken(LEX_EGG.token_t_deuxpoints, yytext(), yyline, yychar, yychar+1);}
					
case -6:
					
	break;
					
case 6:
					
	{return new Yytoken(LEX_EGG.token_t_aco, yytext(), yyline, yychar, yychar+1);}
					
case -7:
					
	break;
					
case 7:
					
	{return new Yytoken(LEX_EGG.token_t_acf, yytext(), yyline, yychar, yychar+1);}
					
case -8:
					
	break;
					
case 8:
					
	{return new Yytoken(LEX_EGG.token_t_cro, yytext(), yyline, yychar, yychar+1);}
					
case -9:
					
	break;
					
case 9:
					
	{return new Yytoken(LEX_EGG.token_t_crf, yytext(), yyline, yychar, yychar+1);}
					
case -10:
					
	break;
					
case 10:
					
	{return new Yytoken(LEX_EGG.token_t_virgule, yytext(), yyline, yychar, yychar+1);}
					
case -11:
					
	break;
					
case 11:
					
	{return new Yytoken(LEX_EGG.token_t_pointvirgule, yytext(), yyline, yychar, yychar+1);}
					
case -12:
					
	break;
					
case 12:
					
	{return new Yytoken(LEX_EGG.token_t_inf, yytext(), yyline, yychar, yychar+1);}
					
case -13:
					
	break;
					
case 13:
					
	{return new Yytoken(LEX_EGG.token_t_sup, yytext(), yyline, yychar, yychar+1);}
					
case -14:
					
	break;
					
case 14:
					
	{return new Yytoken(LEX_EGG.token_t_guillemet, yytext(), yyline, yychar, yychar+1);}
					
case -15:
					
	break;
					
case 15:
					
	{return new Yytoken(LEX_EGG.token_t_fleche, yytext(), yyline, yychar, yychar+1);}
					
case -16:
					
	break;
					
case 16:
					
	{return new Yytoken(LEX_EGG.token_t_is, yytext(), yyline, yychar, yychar+1);}
					
case -17:
					
	break;
					
case 17:
					
	{return new Yytoken(LEX_EGG.token_t_action, yytext(), yyline, yychar, yychar+1);}
					
case -18:
					
	break;
					
case 18:
					
	{return new Yytoken(LEX_EGG.token_commentaires, yytext(), yyline, yychar, yychar+1);}
					
case -19:
					
	break;
					
case 19:
					
	{return new Yytoken(LEX_EGG.token_t_inh, yytext(), yyline, yychar, yychar+1);}
					
case -20:
					
	break;
					
case 20:
					
	{return new Yytoken(LEX_EGG.token_t_syn, yytext(), yyline, yychar, yychar+1);}
					
case -21:
					
	break;
					
case 21:
					
	{return new Yytoken(LEX_EGG.token_t_aka, yytext(), yyline, yychar, yychar+1);}
					
case -22:
					
	break;
					
case 22:
					
	{return new Yytoken(LEX_EGG.token_t_for, yytext(), yyline, yychar, yychar+1);}
					
case -23:
					
	break;
					
case 23:
					
	{return new Yytoken(LEX_EGG.token_t_end, yytext(), yyline, yychar, yychar+1);}
					
case -24:
					
	break;
					
case 24:
					
	{return new Yytoken(LEX_EGG.token_t_alias, yytext(), yyline, yychar, yychar+1);}
					
case -25:
					
	break;
					
case 25:
					
	{return new Yytoken(LEX_EGG.token_big, yytext(), yyline, yychar, yychar+1);}
					
case -26:
					
	break;
					
case 26:
					
	{return new Yytoken(LEX_EGG.token_t_term, yytext(), yyline, yychar, yychar+1);}
					
case -27:
					
	break;
					
case 27:
					
	{return new Yytoken(LEX_EGG.token_t_space, yytext(), yyline, yychar, yychar+1);}
					
case -28:
					
	break;
					
case 28:
					
	{return new Yytoken(LEX_EGG.token_t_sugar, yytext(), yyline, yychar, yychar+1);}
					
case -29:
					
	break;
					
case 29:
					
	{return new Yytoken(LEX_EGG.token_t_macro, yytext(), yyline, yychar, yychar+1);}
					
case -30:
					
	break;
					
case 30:
					
	{return new Yytoken(LEX_EGG.token_t_option, yytext(), yyline, yychar, yychar+1);}
					
case -31:
					
	break;
					
case 31:
					
	{return new Yytoken(LEX_EGG.token_t_external, yytext(), yyline, yychar, yychar+1);}
					
case -32:
					
	break;
					
case 32:
					
	{return new Yytoken(LEX_EGG.token_t_global, yytext(), yyline, yychar, yychar+1);}
					
case -33:
					
	break;
					
case 33:
					
	{return new Yytoken(LEX_EGG.token_t_string, yytext(), yyline, yychar, yychar+1);}
					
case -34:
					
	break;
					
case 34:
					
	{return new Yytoken(LEX_EGG.token_t_double, yytext(), yyline, yychar, yychar+1);}
					
case -35:
					
	break;
					
case 35:
					
	{return new Yytoken(LEX_EGG.token_t_comm, yytext(), yyline, yychar, yychar+1);}
					
case -36:
					
	break;
					
case 36:
					
	{return new Yytoken(LEX_EGG.token_t_integer, yytext(), yyline, yychar, yychar+1);}
					
case -37:
					
	break;
					
case 37:
					
	{return new Yytoken(LEX_EGG.token_t_char, yytext(), yyline, yychar, yychar+1);}
					
case -38:
					
	break;
					
case 39:
					
	{return new Yytoken(LEX_EGG.token_autre, yytext(), yyline, yychar, yychar+1);}
					
case -39:
					
	break;
					
case 40:
					
	{return new Yytoken(LEX_EGG.token_t_ident, yytext(), yyline, yychar, yychar+1);}
					
case -40:
					
	break;
					
case 42:
					
	{return new Yytoken(LEX_EGG.token_autre, yytext(), yyline, yychar, yychar+1);}
					
case -41:
					
	break;
					
case 43:
					
	{return new Yytoken(LEX_EGG.token_t_ident, yytext(), yyline, yychar, yychar+1);}
					
case -42:
					
	break;
					
case 45:
					
	{return new Yytoken(LEX_EGG.token_autre, yytext(), yyline, yychar, yychar+1);}
					
case -43:
					
	break;
					
case 46:
					
	{return new Yytoken(LEX_EGG.token_t_ident, yytext(), yyline, yychar, yychar+1);}
					
case -44:
					
	break;
					
case 48:
					
	{return new Yytoken(LEX_EGG.token_t_ident, yytext(), yyline, yychar, yychar+1);}
					
case -45:
					
	break;
					
case 49:
					
	{return new Yytoken(LEX_EGG.token_t_ident, yytext(), yyline, yychar, yychar+1);}
					
case -46:
					
	break;
					
case 50:
					
	{return new Yytoken(LEX_EGG.token_t_ident, yytext(), yyline, yychar, yychar+1);}
					
case -47:
					
	break;
					
case 51:
					
	{return new Yytoken(LEX_EGG.token_t_ident, yytext(), yyline, yychar, yychar+1);}
					
case -48:
					
	break;
					
case 52:
					
	{return new Yytoken(LEX_EGG.token_t_ident, yytext(), yyline, yychar, yychar+1);}
					
case -49:
					
	break;
					
case 53:
					
	{return new Yytoken(LEX_EGG.token_t_ident, yytext(), yyline, yychar, yychar+1);}
					
case -50:
					
	break;
					
case 54:
					
	{return new Yytoken(LEX_EGG.token_t_ident, yytext(), yyline, yychar, yychar+1);}
					
case -51:
					
	break;
					
case 55:
					
	{return new Yytoken(LEX_EGG.token_t_ident, yytext(), yyline, yychar, yychar+1);}
					
case -52:
					
	break;
					
case 56:
					
	{return new Yytoken(LEX_EGG.token_t_ident, yytext(), yyline, yychar, yychar+1);}
					
case -53:
					
	break;
					
case 57:
					
	{return new Yytoken(LEX_EGG.token_t_ident, yytext(), yyline, yychar, yychar+1);}
					
case -54:
					
	break;
					
case 58:
					
	{return new Yytoken(LEX_EGG.token_t_ident, yytext(), yyline, yychar, yychar+1);}
					
case -55:
					
	break;
					
case 59:
					
	{return new Yytoken(LEX_EGG.token_t_ident, yytext(), yyline, yychar, yychar+1);}
					
case -56:
					
	break;
					
case 60:
					
	{return new Yytoken(LEX_EGG.token_t_ident, yytext(), yyline, yychar, yychar+1);}
					
case -57:
					
	break;
					
case 61:
					
	{return new Yytoken(LEX_EGG.token_t_ident, yytext(), yyline, yychar, yychar+1);}
					
case -58:
					
	break;
					
case 62:
					
	{return new Yytoken(LEX_EGG.token_t_ident, yytext(), yyline, yychar, yychar+1);}
					
case -59:
					
	break;
					
case 63:
					
	{return new Yytoken(LEX_EGG.token_t_ident, yytext(), yyline, yychar, yychar+1);}
					
case -60:
					
	break;
					
case 64:
					
	{return new Yytoken(LEX_EGG.token_t_ident, yytext(), yyline, yychar, yychar+1);}
					
case -61:
					
	break;
					
case 65:
					
	{return new Yytoken(LEX_EGG.token_t_ident, yytext(), yyline, yychar, yychar+1);}
					
case -62:
					
	break;
					
case 66:
					
	{return new Yytoken(LEX_EGG.token_t_ident, yytext(), yyline, yychar, yychar+1);}
					
case -63:
					
	break;
					
case 67:
					
	{return new Yytoken(LEX_EGG.token_t_ident, yytext(), yyline, yychar, yychar+1);}
					
case -64:
					
	break;
					
case 68:
					
	{return new Yytoken(LEX_EGG.token_t_ident, yytext(), yyline, yychar, yychar+1);}
					
case -65:
					
	break;
					
case 69:
					
	{return new Yytoken(LEX_EGG.token_t_ident, yytext(), yyline, yychar, yychar+1);}
					
case -66:
					
	break;
					
case 70:
					
	{return new Yytoken(LEX_EGG.token_t_ident, yytext(), yyline, yychar, yychar+1);}
					
case -67:
					
	break;
					
case 71:
					
	{return new Yytoken(LEX_EGG.token_t_ident, yytext(), yyline, yychar, yychar+1);}
					
case -68:
					
	break;
					
case 72:
					
	{return new Yytoken(LEX_EGG.token_t_ident, yytext(), yyline, yychar, yychar+1);}
					
case -69:
					
	break;
					
case 73:
					
	{return new Yytoken(LEX_EGG.token_t_ident, yytext(), yyline, yychar, yychar+1);}
					
case -70:
					
	break;
					
case 74:
					
	{return new Yytoken(LEX_EGG.token_t_ident, yytext(), yyline, yychar, yychar+1);}
					
case -71:
					
	break;
					
case 75:
					
	{return new Yytoken(LEX_EGG.token_t_ident, yytext(), yyline, yychar, yychar+1);}
					
case -72:
					
	break;
					
case 76:
					
	{return new Yytoken(LEX_EGG.token_t_ident, yytext(), yyline, yychar, yychar+1);}
					
case -73:
					
	break;
					
case 77:
					
	{return new Yytoken(LEX_EGG.token_t_ident, yytext(), yyline, yychar, yychar+1);}
					
case -74:
					
	break;
					
case 78:
					
	{return new Yytoken(LEX_EGG.token_t_ident, yytext(), yyline, yychar, yychar+1);}
					
case -75:
					
	break;
					
case 79:
					
	{return new Yytoken(LEX_EGG.token_t_ident, yytext(), yyline, yychar, yychar+1);}
					
case -76:
					
	break;
					
case 80:
					
	{return new Yytoken(LEX_EGG.token_t_ident, yytext(), yyline, yychar, yychar+1);}
					
case -77:
					
	break;
					
case 81:
					
	{return new Yytoken(LEX_EGG.token_t_ident, yytext(), yyline, yychar, yychar+1);}
					
case -78:
					
	break;
					
case 82:
					
	{return new Yytoken(LEX_EGG.token_t_ident, yytext(), yyline, yychar, yychar+1);}
					
case -79:
					
	break;
					
case 83:
					
	{return new Yytoken(LEX_EGG.token_t_ident, yytext(), yyline, yychar, yychar+1);}
					
case -80:
					
	break;
					
case 84:
					
	{return new Yytoken(LEX_EGG.token_t_ident, yytext(), yyline, yychar, yychar+1);}
					
case -81:
					
	break;
					
case 85:
					
	{return new Yytoken(LEX_EGG.token_t_ident, yytext(), yyline, yychar, yychar+1);}
					
case -82:
					
	break;
					
case 86:
					
	{return new Yytoken(LEX_EGG.token_t_ident, yytext(), yyline, yychar, yychar+1);}
					
case -83:
					
	break;
					
case 87:
					
	{return new Yytoken(LEX_EGG.token_t_ident, yytext(), yyline, yychar, yychar+1);}
					
case -84:
					
	break;
					
case 88:
					
	{return new Yytoken(LEX_EGG.token_t_ident, yytext(), yyline, yychar, yychar+1);}
					
case -85:
					
	break;
					
case 89:
					
	{return new Yytoken(LEX_EGG.token_t_ident, yytext(), yyline, yychar, yychar+1);}
					
case -86:
					
	break;
					
case 90:
					
	{return new Yytoken(LEX_EGG.token_t_ident, yytext(), yyline, yychar, yychar+1);}
					
case -87:
					
	break;
					
case 91:
					
	{return new Yytoken(LEX_EGG.token_t_ident, yytext(), yyline, yychar, yychar+1);}
					
case -88:
					
	break;
					
case 92:
					
	{return new Yytoken(LEX_EGG.token_t_ident, yytext(), yyline, yychar, yychar+1);}
					
case -89:
					
	break;
					
case 93:
					
	{return new Yytoken(LEX_EGG.token_t_ident, yytext(), yyline, yychar, yychar+1);}
					
case -90:
					
	break;
					
case 94:
					
	{return new Yytoken(LEX_EGG.token_t_ident, yytext(), yyline, yychar, yychar+1);}
					
case -91:
					
	break;
					
case 95:
					
	{return new Yytoken(LEX_EGG.token_t_ident, yytext(), yyline, yychar, yychar+1);}
					
case -92:
					
	break;
					
case 96:
					
	{return new Yytoken(LEX_EGG.token_t_ident, yytext(), yyline, yychar, yychar+1);}
					
case -93:
					
	break;
					
case 97:
					
	{return new Yytoken(LEX_EGG.token_t_ident, yytext(), yyline, yychar, yychar+1);}
					
case -94:
					
	break;
					
case 98:
					
	{return new Yytoken(LEX_EGG.token_t_ident, yytext(), yyline, yychar, yychar+1);}
					
case -95:
					
	break;
					
case 99:
					
	{return new Yytoken(LEX_EGG.token_t_ident, yytext(), yyline, yychar, yychar+1);}
					
case -96:
					
	break;
					
case 100:
					
	{return new Yytoken(LEX_EGG.token_t_ident, yytext(), yyline, yychar, yychar+1);}
					
case -97:
					
	break;
					
case 101:
					
	{return new Yytoken(LEX_EGG.token_t_ident, yytext(), yyline, yychar, yychar+1);}
					
case -98:
					
	break;
					
case 102:
					
	{return new Yytoken(LEX_EGG.token_t_ident, yytext(), yyline, yychar, yychar+1);}
					
case -99:
					
	break;
					
case 103:
					
	{return new Yytoken(LEX_EGG.token_t_ident, yytext(), yyline, yychar, yychar+1);}
					
case -100:
					
	break;
					
case 104:
					
	{return new Yytoken(LEX_EGG.token_t_ident, yytext(), yyline, yychar, yychar+1);}
					
case -101:
					
	break;
					
case 105:
					
	{return new Yytoken(LEX_EGG.token_t_ident, yytext(), yyline, yychar, yychar+1);}
					
case -102:
					
	break;
					
case 106:
					
	{return new Yytoken(LEX_EGG.token_t_ident, yytext(), yyline, yychar, yychar+1);}
					
case -103:
					
	break;
					
case 107:
					
	{return new Yytoken(LEX_EGG.token_t_ident, yytext(), yyline, yychar, yychar+1);}
					
case -104:
					
	break;
					
case 108:
					
	{return new Yytoken(LEX_EGG.token_t_ident, yytext(), yyline, yychar, yychar+1);}
					
case -105:
					
	break;
					
case 109:
					
	{return new Yytoken(LEX_EGG.token_t_ident, yytext(), yyline, yychar, yychar+1);}
					
case -106:
					
	break;
					default:
						yy_error(YY_E_INTERNAL,false);
					case -1:
					}
					yy_initial = true;
					yy_state = yy_state_dtrans[yy_lexical_state];
					yy_next_state = YY_NO_STATE;
					yy_last_accept_state = YY_NO_STATE;
					yy_mark_start();
					yy_this_accept = yy_acpt[yy_state];
					if (YY_NOT_ACCEPT != yy_this_accept) {
						yy_last_accept_state = yy_state;
						yy_mark_end();
					}
				}
			}
		}
	}
}
