package mg.egg.eggc.compiler.egg.java;
import mg.egg.eggc.runtime.libjava.lex.*;

public class JLEX_LACTION implements  LEX_ANALYZER  {
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

	public JLEX_LACTION (java.io.Reader reader) {
		this ();
		if (null == reader) {
			throw (new Error("Error: Bad input stream initializer."));
		}
		yy_reader = new java.io.BufferedReader(reader);
	}

	public JLEX_LACTION (java.io.InputStream instream) {
		this ();
		if (null == instream) {
			throw (new Error("Error: Bad input stream initializer."));
		}
		yy_reader = new java.io.BufferedReader(new java.io.InputStreamReader(instream));
	}

	public JLEX_LACTION () {
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
		/* 38 */ YY_NO_ANCHOR,
		/* 39 */ YY_NO_ANCHOR,
		/* 40 */ YY_NO_ANCHOR,
		/* 41 */ YY_NO_ANCHOR,
		/* 42 */ YY_NO_ANCHOR,
		/* 43 */ YY_NO_ANCHOR,
		/* 44 */ YY_NO_ANCHOR,
		/* 45 */ YY_NO_ANCHOR,
		/* 46 */ YY_NO_ANCHOR,
		/* 47 */ YY_NO_ANCHOR,
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
		/* 62 */ YY_NOT_ACCEPT,
		/* 63 */ YY_NO_ANCHOR,
		/* 64 */ YY_NO_ANCHOR,
		/* 65 */ YY_NO_ANCHOR,
		/* 66 */ YY_NO_ANCHOR,
		/* 67 */ YY_NO_ANCHOR,
		/* 68 */ YY_NO_ANCHOR,
		/* 69 */ YY_NOT_ACCEPT,
		/* 70 */ YY_NO_ANCHOR,
		/* 71 */ YY_NO_ANCHOR,
		/* 72 */ YY_NOT_ACCEPT,
		/* 73 */ YY_NO_ANCHOR,
		/* 74 */ YY_NOT_ACCEPT,
		/* 75 */ YY_NO_ANCHOR,
		/* 76 */ YY_NOT_ACCEPT,
		/* 77 */ YY_NO_ANCHOR,
		/* 78 */ YY_NOT_ACCEPT,
		/* 79 */ YY_NO_ANCHOR,
		/* 80 */ YY_NOT_ACCEPT,
		/* 81 */ YY_NO_ANCHOR,
		/* 82 */ YY_NOT_ACCEPT,
		/* 83 */ YY_NO_ANCHOR,
		/* 84 */ YY_NOT_ACCEPT,
		/* 85 */ YY_NO_ANCHOR,
		/* 86 */ YY_NOT_ACCEPT,
		/* 87 */ YY_NO_ANCHOR,
		/* 88 */ YY_NOT_ACCEPT,
		/* 89 */ YY_NO_ANCHOR,
		/* 90 */ YY_NOT_ACCEPT,
		/* 91 */ YY_NO_ANCHOR,
		/* 92 */ YY_NOT_ACCEPT,
		/* 93 */ YY_NO_ANCHOR,
		/* 94 */ YY_NOT_ACCEPT,
		/* 95 */ YY_NO_ANCHOR,
		/* 96 */ YY_NOT_ACCEPT,
		/* 97 */ YY_NO_ANCHOR,
		/* 98 */ YY_NOT_ACCEPT,
		/* 99 */ YY_NO_ANCHOR,
		/* 100 */ YY_NOT_ACCEPT,
		/* 101 */ YY_NO_ANCHOR,
		/* 102 */ YY_NO_ANCHOR,
		/* 103 */ YY_NO_ANCHOR,
		/* 104 */ YY_NO_ANCHOR,
		/* 105 */ YY_NO_ANCHOR,
		/* 106 */ YY_NO_ANCHOR,
		/* 107 */ YY_NO_ANCHOR,
		/* 108 */ YY_NO_ANCHOR,
		/* 109 */ YY_NO_ANCHOR,
		/* 110 */ YY_NOT_ACCEPT,
		/* 111 */ YY_NOT_ACCEPT,
		/* 112 */ YY_NO_ANCHOR,
		/* 113 */ YY_NOT_ACCEPT,
		/* 114 */ YY_NO_ANCHOR,
		/* 115 */ YY_NO_ANCHOR,
		/* 116 */ YY_NO_ANCHOR,
		/* 117 */ YY_NO_ANCHOR,
		/* 118 */ YY_NO_ANCHOR,
		/* 119 */ YY_NO_ANCHOR,
		/* 120 */ YY_NO_ANCHOR,
		/* 121 */ YY_NO_ANCHOR,
		/* 122 */ YY_NO_ANCHOR,
		/* 123 */ YY_NO_ANCHOR,
		/* 124 */ YY_NO_ANCHOR,
		/* 125 */ YY_NO_ANCHOR,
		/* 126 */ YY_NO_ANCHOR,
		/* 127 */ YY_NO_ANCHOR,
		/* 128 */ YY_NO_ANCHOR,
		/* 129 */ YY_NO_ANCHOR,
		/* 130 */ YY_NO_ANCHOR,
		/* 131 */ YY_NO_ANCHOR,
		/* 132 */ YY_NO_ANCHOR,
		/* 133 */ YY_NO_ANCHOR,
		/* 134 */ YY_NOT_ACCEPT,
		/* 135 */ YY_NO_ANCHOR,
		/* 136 */ YY_NOT_ACCEPT,
		/* 137 */ YY_NO_ANCHOR,
		/* 138 */ YY_NO_ANCHOR,
		/* 139 */ YY_NO_ANCHOR,
		/* 140 */ YY_NO_ANCHOR,
		/* 141 */ YY_NO_ANCHOR,
		/* 142 */ YY_NO_ANCHOR,
		/* 143 */ YY_NO_ANCHOR,
		/* 144 */ YY_NO_ANCHOR,
		/* 145 */ YY_NO_ANCHOR,
		/* 146 */ YY_NO_ANCHOR,
		/* 147 */ YY_NO_ANCHOR,
		/* 148 */ YY_NO_ANCHOR,
		/* 149 */ YY_NO_ANCHOR,
		/* 150 */ YY_NO_ANCHOR,
		/* 151 */ YY_NOT_ACCEPT,
		/* 152 */ YY_NO_ANCHOR,
		/* 153 */ YY_NO_ANCHOR,
		/* 154 */ YY_NO_ANCHOR,
		/* 155 */ YY_NO_ANCHOR,
		/* 156 */ YY_NO_ANCHOR,
		/* 157 */ YY_NO_ANCHOR,
		/* 158 */ YY_NO_ANCHOR,
		/* 159 */ YY_NO_ANCHOR,
		/* 160 */ YY_NO_ANCHOR,
		/* 161 */ YY_NO_ANCHOR,
		/* 162 */ YY_NO_ANCHOR,
		/* 163 */ YY_NO_ANCHOR,
		/* 164 */ YY_NO_ANCHOR,
		/* 165 */ YY_NO_ANCHOR,
		/* 166 */ YY_NO_ANCHOR,
		/* 167 */ YY_NO_ANCHOR,
		/* 168 */ YY_NO_ANCHOR,
		/* 169 */ YY_NO_ANCHOR,
		/* 170 */ YY_NO_ANCHOR,
		/* 171 */ YY_NO_ANCHOR,
		/* 172 */ YY_NO_ANCHOR
	};
	private int yy_cmap[] = unpackFromString(1,258,
"3:9,4,1,3:2,4,3:18,4,35,61,3:2,66,32,67,14,15,5,30,8,2,6,31,64:4,65:4,60:2," +"10,9,12,11,13,3,36,57,53,55,50,49,63,48,56,46,68:2,54,68,47,51,68:2,45,43,4" +"4,52,68:5,41,62,42,7,68,3,22,39,21,18,23,37,28,26,16,68:2,20,38,24,19,59,68" +",27,17,29,40,68,25,58,68:2,3,33,3,34,3:129,0:2")[0];

	private int yy_rmap[] = unpackFromString(1,173,
"0,1,2,3,1,4,5,1:3,6,1:5,7,8,9,10,11,1:4,12,1:2,13,1,14:3,1:5,14:3,1:2,14,15" +",14:17,16,17,14,1:2,18,19,20,21,22,5,23,17,24,25,26,27,28,29,30,31,32,33,34" +",35,36,37,38,39,40,19,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58" +",59,60,61,62,63,64,65,66,67,68,69,70,71,72,73,74,75,76,77,78,79,80,81,82,83" +",84,85,86,87,88,89,90,91,92,93,94,95,96,97,98,99,100,101,102,103,104,105,10" +"6,107,108,109,110,111,112,113,114,115,116,117,118,119,120")[0];

	private int yy_nxt[][] = unpackFromString(121,69,
"1,2,3,4,2,5,6,7,8,9,10,11,12,13,14,15,16,64,71,64,150,133,64,109,112,135,64" +":3,137,17,18,19,20,21,67,22,152,153,154,64,23,24,161,64:2,167,64:3,162,64:4" +",172,64:4,25,63,4,64,25:2,4,70,64,-1:70,2,-1:2,2,-1:66,62,-1:2,69,26,-1:68," +"27,-1:122,28,-1:3,28:2,-1:14,29,-1:73,64,30,64:12,-1:7,31,64:3,-1:2,64:18,-" +"1:2,64:3,-1:2,64,-1:6,33,-1:68,34,-1:4,35,-1:89,65,-1:69,66,-1:41,72,-1:53," +"25,-1:3,25:2,-1:26,86,-1:36,28,-1:3,28:2,-1:19,64:14,-1:7,64:4,-1:2,64:18,-" +"1:2,64:3,-1:2,64,-1:16,102,64:13,-1:7,64:4,-1:2,64:18,-1:2,64:3,-1:2,64,-1," +"37,62:67,-1,74:60,36,76,74:6,-1:11,35,-1:117,68,-1:3,68:2,-1:4,69:4,84,69:6" +"3,-1,78:61,80,78:3,82,-1,78,-1:16,64:3,32,64:10,-1:7,64:4,-1:2,64:18,-1:2,6" +"4:3,-1:2,64,-1:16,64:2,38,64:11,-1:7,64:4,-1:2,64:18,-1:2,64:3,-1:2,64,-1:1" +"6,64:4,39,64:9,-1:7,64:4,-1:2,64:18,-1:2,64:3,-1:2,64,-1:24,74,-1:2,74,-1,7" +"4,-1:7,74,-1,74,88,-1:20,74:2,-1,90,-1:20,64:9,40,64:4,-1:7,64:4,-1:2,64:18" +",-1:2,64:3,-1:2,64,-1:67,41,-1:17,64:4,43,64:9,-1:7,64:4,-1:2,64:18,-1:2,64" +":3,-1:2,64,-1:24,78,-1:2,78,-1,78,-1:7,78,-1,78,151,-1:21,78,-1,111,-1:2,78" +",-1:17,64:7,44,64:6,-1:7,64:4,-1:2,64:18,-1:2,64:3,-1:2,64,-1:44,78,-1:2,78" +",-1:19,41,-1:17,64:10,45,64:3,-1:7,64:4,-1:2,64:18,-1:2,64:3,-1:2,64,-1,69," +"42,69:2,84,69:63,-1:16,64:8,46,64:5,-1:7,64:4,-1:2,64:18,-1:2,64:3,-1:2,64," +"-1:2,92,-1:27,92,-1:29,68,-1:3,68:2,-1:19,64:8,47,64:5,-1:7,64:4,-1:2,64:18" +",-1:2,64:3,-1:2,64,-1:18,134,-1:2,134:3,-1:13,134,-1,134,-1:9,134:2,-1:2,13" +"4,-1,134,-1,134,-1:2,134,-1:2,134:3,-1:19,64:7,48,64:6,-1:7,64:4,-1:2,64:18" +",-1:2,64:3,-1:2,64,-1:64,94:2,-1:19,64:4,49,64:9,-1:7,64:4,-1:2,64:18,-1:2," +"64:3,-1:2,64,-1:16,64:11,50,64:2,-1:7,64:4,-1:2,64:18,-1:2,64:3,-1:2,64,-1:" +"64,74:2,-1:19,64:7,51,64:6,-1:7,64:4,-1:2,64:18,-1:2,64:3,-1:2,64,-1:64,78:" +"2,-1:19,64:7,52,64:6,-1:7,64:4,-1:2,64:18,-1:2,64:3,-1:2,64,-1:18,74,-1:2,7" +"4:3,-1:13,74,-1,74,-1:9,74:2,-1:2,74,-1,74,-1,74,-1:2,74,-1:2,74:3,-1:19,64" +":10,53,64:3,-1:7,64:4,-1:2,64:18,-1:2,64:3,-1:2,64,-1:18,78,-1:2,78:3,-1:13" +",78,-1,78,-1:9,78:2,-1:2,78,-1,78,-1,78,-1:2,78,-1:2,78:3,-1:19,64:8,54,64:" +"5,-1:7,64:4,-1:2,64:18,-1:2,64:3,-1:2,64,-1:16,64:14,-1:7,55,64:3,-1:2,64:1" +"8,-1:2,64:3,-1:2,64,-1:16,64:14,-1:7,64:4,-1:2,64:5,56,64:12,-1:2,64:3,-1:2" +",64,-1:16,64:14,-1:7,64:4,-1:2,64:6,57,64:11,-1:2,64:3,-1:2,64,-1:16,64:12," +"58,64,-1:7,64:4,-1:2,64:18,-1:2,64:3,-1:2,64,-1:16,64:14,-1:7,64:4,-1:2,64:" +"2,59,64:15,-1:2,64:3,-1:2,64,-1:16,64:8,60,64:5,-1:7,64:4,-1:2,64:18,-1:2,6" +"4:3,-1:2,64,-1:16,64:14,-1:7,64:4,-1:2,64:2,61,64:15,-1:2,64:3,-1:2,64,-1:1" +"6,64:4,115,64:3,73,64:2,139,64:2,-1:7,64:4,-1:2,64:15,170,64:2,-1:2,64:3,-1" +":2,64,-1:18,98,-1:2,98:3,-1:13,98,-1,98,-1:9,98:2,-1:2,98,-1,98,-1,98,-1:2," +"98,-1:2,98:3,-1:67,96:2,-1:19,75,64:6,77,64:6,-1:7,64:3,116,-1:2,64:18,-1:2" +",64:3,-1:2,64,-1:18,100,-1:2,100:3,-1:13,100,-1,100,-1:9,100:2,-1:2,100,-1," +"100,-1,100,-1:2,100,-1:2,100:3,-1:19,64:4,79,64:9,-1:7,64:4,-1:2,64:18,-1:2" +",64:3,-1:2,64,-1:16,64,81,64:12,-1:7,64:4,-1:2,64:18,-1:2,64:3,-1:2,64,-1:1" +"6,64:4,75,64:9,-1:7,64:4,-1:2,64:18,-1:2,64:3,-1:2,64,-1:16,64:13,83,-1:7,6" +"4:4,-1:2,64:18,-1:2,64:3,-1:2,64,-1:16,64:7,85,64:6,-1:7,64:4,-1:2,64:18,-1" +":2,64:3,-1:2,64,-1:16,64:7,87,64:6,-1:7,64:4,-1:2,64:18,-1:2,64:3,-1:2,64,-" +"1:16,64:14,-1:7,64:3,89,-1:2,64:18,-1:2,64:3,-1:2,64,-1:16,64:6,91,64:7,-1:" +"7,64:4,-1:2,64:18,-1:2,64:3,-1:2,64,-1:16,64:3,93,64:10,-1:7,64:4,-1:2,64:1" +"8,-1:2,64:3,-1:2,64,-1:16,64:13,95,-1:7,64:4,-1:2,64:18,-1:2,64:3,-1:2,64,-" +"1:16,64,97,64:12,-1:7,64:4,-1:2,64:18,-1:2,64:3,-1:2,64,-1:16,64:5,99,64:8," +"-1:7,64:4,-1:2,64:18,-1:2,64:3,-1:2,64,-1:16,101,64:13,-1:7,64:4,-1:2,64:18" +",-1:2,64:3,-1:2,64,-1:16,64:14,-1:7,64:4,-1:2,64:4,103,64:13,-1:2,64:3,-1:2" +",64,-1:16,64:14,-1:7,64:4,-1:2,64:11,104,64:6,-1:2,64:3,-1:2,64,-1:16,64:8," +"105,64:5,-1:7,64:4,-1:2,64:18,-1:2,64:3,-1:2,64,-1:16,64:14,-1:7,64:4,-1:2," +"64:6,106,64:11,-1:2,64:3,-1:2,64,-1:16,64:3,107,64:10,-1:7,64:4,-1:2,64:18," +"-1:2,64:3,-1:2,64,-1:16,64:14,-1:7,64:4,-1:2,64:6,108,64:11,-1:2,64:3,-1:2," +"64,-1:16,64:6,114,64:7,-1:7,64:4,-1:2,64:18,-1:2,64:3,-1:2,64,-1:18,110,-1:" +"2,110:3,-1:13,110,-1,110,-1:9,110:2,-1:2,110,-1,110,-1,110,-1:2,110,-1:2,11" +"0:3,-1:19,117,64:5,163,64:3,118,140,64:2,-1:7,64:4,-1:2,64:18,-1:2,64:3,-1:" +"2,64,-1:18,113,-1:2,113:3,-1:13,113,-1,113,-1:9,113:2,-1:2,113,-1,113,-1,11" +"3,-1:2,113,-1:2,113:3,-1:19,64:10,119,120,64:2,-1:7,64:4,-1:2,64:18,-1:2,64" +":3,-1:2,64,-1:16,64:5,121,64:8,-1:7,64:4,-1:2,64:18,-1:2,64:3,-1:2,64,-1:16" +",64:11,122,64:2,-1:7,64:4,-1:2,64:18,-1:2,64:3,-1:2,64,-1:16,123,64:13,-1:7" +",64:4,-1:2,64:18,-1:2,64:3,-1:2,64,-1:16,64:4,124,64:9,-1:7,64:4,-1:2,64:18" +",-1:2,64:3,-1:2,64,-1:16,64:13,125,-1:7,64:4,-1:2,64:18,-1:2,64:3,-1:2,64,-" +"1:16,64:12,126,64,-1:7,64:4,-1:2,64:18,-1:2,64:3,-1:2,64,-1:16,64:14,-1:7,6" +"4:4,-1:2,64:3,127,64:14,-1:2,64:3,-1:2,64,-1:16,64:14,-1:7,64:4,-1:2,64:10," +"128,64:7,-1:2,64:3,-1:2,64,-1:16,129,64:13,-1:7,64:4,-1:2,64:18,-1:2,64:3,-" +"1:2,64,-1:16,64:14,-1:7,64:4,-1:2,64:5,130,64:12,-1:2,64:3,-1:2,64,-1:16,13" +"1,64:13,-1:7,64:4,-1:2,64:18,-1:2,64:3,-1:2,64,-1:16,64:14,-1:7,64:4,-1:2,6" +"4,132,64:16,-1:2,64:3,-1:2,64,-1:16,64:3,138,64:10,-1:7,64:4,-1:2,64:18,-1:" +"2,64:3,-1:2,64,-1:18,136,-1:2,136:3,-1:13,136,-1,136,-1:9,136:2,-1:2,136,-1" +",136,-1,136,-1:2,136,-1:2,136:3,-1:19,64:6,141,64:7,-1:7,64:4,-1:2,64:18,-1" +":2,64:3,-1:2,64,-1:16,64:6,142,64:7,-1:7,64:4,-1:2,64:18,-1:2,64:3,-1:2,64," +"-1:16,64:7,143,64:6,-1:7,64:4,-1:2,64:18,-1:2,64:3,-1:2,64,-1:16,64:14,-1:7" +",64:4,-1:2,64:2,144,64:15,-1:2,64:3,-1:2,64,-1:16,64:14,-1:7,64:4,-1:2,64:9" +",145,64:8,-1:2,64:3,-1:2,64,-1:16,64:8,146,64:5,-1:7,64:4,-1:2,64:18,-1:2,6" +"4:3,-1:2,64,-1:16,64:14,-1:7,64:4,-1:2,64:6,147,64:11,-1:2,64:3,-1:2,64,-1:" +"16,64:13,148,-1:7,64:4,-1:2,64:18,-1:2,64:3,-1:2,64,-1:16,64:14,-1:7,64:4,-" +"1:2,64:12,149,64:5,-1:2,64:3,-1:2,64,-1:16,64:14,-1:7,64:4,-1:2,64,155,64:1" +"6,-1:2,64:3,-1:2,64,-1:16,64:14,-1:7,64:4,-1:2,64:8,156,64:9,-1:2,64:3,-1:2" +",64,-1:16,64:11,157,64:2,-1:7,64:4,-1:2,64:18,-1:2,64:3,-1:2,64,-1:16,64:14" +",-1:7,64:4,-1:2,64,158,64:16,-1:2,64:3,-1:2,64,-1:16,64:14,-1:7,64:4,-1:2,6" +"4:16,159,64,-1:2,64:3,-1:2,64,-1:16,64:14,-1:7,64:4,-1:2,64:14,160,64:3,-1:" +"2,64:3,-1:2,64,-1:16,64:14,-1:7,64:4,-1:2,64:4,164,64:13,-1:2,64:3,-1:2,64," +"-1:16,64:7,165,64:6,-1:7,64:4,-1:2,64:18,-1:2,64:3,-1:2,64,-1:16,64:14,-1:7" +",64:4,-1:2,64:2,166,64:15,-1:2,64:3,-1:2,64,-1:16,64:5,168,64:8,-1:7,64:4,-" +"1:2,64:18,-1:2,64:3,-1:2,64,-1:16,64:14,-1:7,64:4,-1:2,64:14,169,64:3,-1:2," +"64:3,-1:2,64,-1:16,64:14,-1:7,64:4,-1:2,64:13,171,64:4,-1:2,64:3,-1:2,64");

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

	return new Yytoken(LEX_LACTION.EOF , "EOF" , yyline , yychar , yychar+1 ) ;
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
					
	{return new Yytoken(LEX_LACTION.token_separateur, yytext(), yyline, yychar, yychar+1);}
					
case -3:
					
	break;
					
case 3:
					
	{return new Yytoken(LEX_LACTION.token_t_moins, yytext(), yyline, yychar, yychar+1);}
					
case -4:
					
	break;
					
case 4:
					
	{return new Yytoken(LEX_LACTION.token_autre, yytext(), yyline, yychar, yychar+1);}
					
case -5:
					
	break;
					
case 5:
					
	{return new Yytoken(LEX_LACTION.token_t_mult, yytext(), yyline, yychar, yychar+1);}
					
case -6:
					
	break;
					
case 6:
					
	{return new Yytoken(LEX_LACTION.token_t_point, yytext(), yyline, yychar, yychar+1);}
					
case -7:
					
	break;
					
case 7:
					
	{return new Yytoken(LEX_LACTION.token_t_chapeau, yytext(), yyline, yychar, yychar+1);}
					
case -8:
					
	break;
					
case 8:
					
	{return new Yytoken(LEX_LACTION.token_t_virgule, yytext(), yyline, yychar, yychar+1);}
					
case -9:
					
	break;
					
case 9:
					
	{return new Yytoken(LEX_LACTION.token_t_pointvirgule, yytext(), yyline, yychar, yychar+1);}
					
case -10:
					
	break;
					
case 10:
					
	{return new Yytoken(LEX_LACTION.token_t_deuxpoints, yytext(), yyline, yychar, yychar+1);}
					
case -11:
					
	break;
					
case 11:
					
	{return new Yytoken(LEX_LACTION.token_t_egal, yytext(), yyline, yychar, yychar+1);}
					
case -12:
					
	break;
					
case 12:
					
	{return new Yytoken(LEX_LACTION.token_t_inf, yytext(), yyline, yychar, yychar+1);}
					
case -13:
					
	break;
					
case 13:
					
	{return new Yytoken(LEX_LACTION.token_t_sup, yytext(), yyline, yychar, yychar+1);}
					
case -14:
					
	break;
					
case 14:
					
	{return new Yytoken(LEX_LACTION.token_t_paro, yytext(), yyline, yychar, yychar+1);}
					
case -15:
					
	break;
					
case 15:
					
	{return new Yytoken(LEX_LACTION.token_t_parf, yytext(), yyline, yychar, yychar+1);}
					
case -16:
					
	break;
					
case 16:
					
	{return new Yytoken(LEX_LACTION.token_t_ident, yytext(), yyline, yychar, yychar+1);}
					
case -17:
					
	break;
					
case 17:
					
	{return new Yytoken(LEX_LACTION.token_t_plus, yytext(), yyline, yychar, yychar+1);}
					
case -18:
					
	break;
					
case 18:
					
	{return new Yytoken(LEX_LACTION.token_t_div, yytext(), yyline, yychar, yychar+1);}
					
case -19:
					
	break;
					
case 19:
					
	{return new Yytoken(LEX_LACTION.token_t_et, yytext(), yyline, yychar, yychar+1);}
					
case -20:
					
	break;
					
case 20:
					
	{return new Yytoken(LEX_LACTION.token_t_ou, yytext(), yyline, yychar, yychar+1);}
					
case -21:
					
	break;
					
case 21:
					
	{return new Yytoken(LEX_LACTION.token_t_not, yytext(), yyline, yychar, yychar+1);}
					
case -22:
					
	break;
					
case 22:
					
	{return new Yytoken(LEX_LACTION.token_t_append, yytext(), yyline, yychar, yychar+1);}
					
case -23:
					
	break;
					
case 23:
					
	{return new Yytoken(LEX_LACTION.token_t_cro, yytext(), yyline, yychar, yychar+1);}
					
case -24:
					
	break;
					
case 24:
					
	{return new Yytoken(LEX_LACTION.token_t_crf, yytext(), yyline, yychar, yychar+1);}
					
case -25:
					
	break;
					
case 25:
					
	{return new Yytoken(LEX_LACTION.token_t_entier, yytext(), yyline, yychar, yychar+1);}
					
case -26:
					
	break;
					
case 26:
					
	{return new Yytoken(LEX_LACTION.token_t_d_moins, yytext(), yyline, yychar, yychar+1);}
					
case -27:
					
	break;
					
case 27:
					
	{return new Yytoken(LEX_LACTION.token_t_d_mult, yytext(), yyline, yychar, yychar+1);}
					
case -28:
					
	break;
					
case 28:
					
	{return new Yytoken(LEX_LACTION.token_t_flottant, yytext(), yyline, yychar, yychar+1);}
					
case -29:
					
	break;
					
case 29:
					
	{return new Yytoken(LEX_LACTION.token_t_affectation, yytext(), yyline, yychar, yychar+1);}
					
case -30:
					
	break;
					
case 30:
					
	{return new Yytoken(LEX_LACTION.token_t_is, yytext(), yyline, yychar, yychar+1);}
					
case -31:
					
	break;
					
case 31:
					
	{return new Yytoken(LEX_LACTION.token_t_if, yytext(), yyline, yychar, yychar+1);}
					
case -32:
					
	break;
					
case 32:
					
	{return new Yytoken(LEX_LACTION.token_t_do, yytext(), yyline, yychar, yychar+1);}
					
case -33:
					
	break;
					
case 33:
					
	{return new Yytoken(LEX_LACTION.token_t_d_plus, yytext(), yyline, yychar, yychar+1);}
					
case -34:
					
	break;
					
case 34:
					
	{return new Yytoken(LEX_LACTION.token_t_d_div, yytext(), yyline, yychar, yychar+1);}
					
case -35:
					
	break;
					
case 35:
					
	{return new Yytoken(LEX_LACTION.token_t_different, yytext(), yyline, yychar, yychar+1);}
					
case -36:
					
	break;
					
case 36:
					
	{return new Yytoken(LEX_LACTION.token_t_chaine, yytext(), yyline, yychar, yychar+1);}
					
case -37:
					
	break;
					
case 37:
					
	{return new Yytoken(LEX_LACTION.token_commentaires, yytext(), yyline, yychar, yychar+1);}
					
case -38:
					
	break;
					
case 38:
					
	{return new Yytoken(LEX_LACTION.token_t_end, yytext(), yyline, yychar, yychar+1);}
					
case -39:
					
	break;
					
case 39:
					
	{return new Yytoken(LEX_LACTION.token_t_nil, yytext(), yyline, yychar, yychar+1);}
					
case -40:
					
	break;
					
case 40:
					
	{return new Yytoken(LEX_LACTION.token_t_new, yytext(), yyline, yychar, yychar+1);}
					
case -41:
					
	break;
					
case 41:
					
	{return new Yytoken(LEX_LACTION.token_t_car, yytext(), yyline, yychar, yychar+1);}
					
case -42:
					
	break;
					
case 42:
					
	{return new Yytoken(LEX_LACTION.token_big, yytext(), yyline, yychar, yychar+1);}
					
case -43:
					
	break;
					
case 43:
					
	{return new Yytoken(LEX_LACTION.token_t_call, yytext(), yyline, yychar, yychar+1);}
					
case -44:
					
	break;
					
case 44:
					
	{return new Yytoken(LEX_LACTION.token_t_else, yytext(), yyline, yychar, yychar+1);}
					
case -45:
					
	break;
					
case 45:
					
	{return new Yytoken(LEX_LACTION.token_t_with, yytext(), yyline, yychar, yychar+1);}
					
case -46:
					
	break;
					
case 46:
					
	{return new Yytoken(LEX_LACTION.token_t_when, yytext(), yyline, yychar, yychar+1);}
					
case -47:
					
	break;
					
case 47:
					
	{return new Yytoken(LEX_LACTION.token_t_then, yytext(), yyline, yychar, yychar+1);}
					
case -48:
					
	break;
					
case 48:
					
	{return new Yytoken(LEX_LACTION.token_t_true, yytext(), yyline, yychar, yychar+1);}
					
case -49:
					
	break;
					
case 49:
					
	{return new Yytoken(LEX_LACTION.token_t_local, yytext(), yyline, yychar, yychar+1);}
					
case -50:
					
	break;
					
case 50:
					
	{return new Yytoken(LEX_LACTION.token_t_error, yytext(), yyline, yychar, yychar+1);}
					
case -51:
					
	break;
					
case 51:
					
	{return new Yytoken(LEX_LACTION.token_t_write, yytext(), yyline, yychar, yychar+1);}
					
case -52:
					
	break;
					
case 52:
					
	{return new Yytoken(LEX_LACTION.token_t_false, yytext(), yyline, yychar, yychar+1);}
					
case -53:
					
	break;
					
case 53:
					
	{return new Yytoken(LEX_LACTION.token_t_match, yytext(), yyline, yychar, yychar+1);}
					
case -54:
					
	break;
					
case 54:
					
	{return new Yytoken(LEX_LACTION.token_t_begin, yytext(), yyline, yychar, yychar+1);}
					
case -55:
					
	break;
					
case 55:
					
	{return new Yytoken(LEX_LACTION.token_t_elseif, yytext(), yyline, yychar, yychar+1);}
					
case -56:
					
	break;
					
case 56:
					
	{return new Yytoken(LEX_LACTION.token_t_string, yytext(), yyline, yychar, yychar+1);}
					
case -57:
					
	break;
					
case 57:
					
	{return new Yytoken(LEX_LACTION.token_t_double, yytext(), yyline, yychar, yychar+1);}
					
case -58:
					
	break;
					
case 58:
					
	{return new Yytoken(LEX_LACTION.token_t_attention, yytext(), yyline, yychar, yychar+1);}
					
case -59:
					
	break;
					
case 59:
					
	{return new Yytoken(LEX_LACTION.token_t_integer, yytext(), yyline, yychar, yychar+1);}
					
case -60:
					
	break;
					
case 60:
					
	{return new Yytoken(LEX_LACTION.token_t_exception, yytext(), yyline, yychar, yychar+1);}
					
case -61:
					
	break;
					
case 61:
					
	{return new Yytoken(LEX_LACTION.token_t_char, yytext(), yyline, yychar, yychar+1);}
					
case -62:
					
	break;
					
case 63:
					
	{return new Yytoken(LEX_LACTION.token_autre, yytext(), yyline, yychar, yychar+1);}
					
case -63:
					
	break;
					
case 64:
					
	{return new Yytoken(LEX_LACTION.token_t_ident, yytext(), yyline, yychar, yychar+1);}
					
case -64:
					
	break;
					
case 65:
					
	{return new Yytoken(LEX_LACTION.token_t_et, yytext(), yyline, yychar, yychar+1);}
					
case -65:
					
	break;
					
case 66:
					
	{return new Yytoken(LEX_LACTION.token_t_ou, yytext(), yyline, yychar, yychar+1);}
					
case -66:
					
	break;
					
case 67:
					
	{return new Yytoken(LEX_LACTION.token_t_not, yytext(), yyline, yychar, yychar+1);}
					
case -67:
					
	break;
					
case 68:
					
	{return new Yytoken(LEX_LACTION.token_t_flottant, yytext(), yyline, yychar, yychar+1);}
					
case -68:
					
	break;
					
case 70:
					
	{return new Yytoken(LEX_LACTION.token_autre, yytext(), yyline, yychar, yychar+1);}
					
case -69:
					
	break;
					
case 71:
					
	{return new Yytoken(LEX_LACTION.token_t_ident, yytext(), yyline, yychar, yychar+1);}
					
case -70:
					
	break;
					
case 73:
					
	{return new Yytoken(LEX_LACTION.token_t_ident, yytext(), yyline, yychar, yychar+1);}
					
case -71:
					
	break;
					
case 75:
					
	{return new Yytoken(LEX_LACTION.token_t_ident, yytext(), yyline, yychar, yychar+1);}
					
case -72:
					
	break;
					
case 77:
					
	{return new Yytoken(LEX_LACTION.token_t_ident, yytext(), yyline, yychar, yychar+1);}
					
case -73:
					
	break;
					
case 79:
					
	{return new Yytoken(LEX_LACTION.token_t_ident, yytext(), yyline, yychar, yychar+1);}
					
case -74:
					
	break;
					
case 81:
					
	{return new Yytoken(LEX_LACTION.token_t_ident, yytext(), yyline, yychar, yychar+1);}
					
case -75:
					
	break;
					
case 83:
					
	{return new Yytoken(LEX_LACTION.token_t_ident, yytext(), yyline, yychar, yychar+1);}
					
case -76:
					
	break;
					
case 85:
					
	{return new Yytoken(LEX_LACTION.token_t_ident, yytext(), yyline, yychar, yychar+1);}
					
case -77:
					
	break;
					
case 87:
					
	{return new Yytoken(LEX_LACTION.token_t_ident, yytext(), yyline, yychar, yychar+1);}
					
case -78:
					
	break;
					
case 89:
					
	{return new Yytoken(LEX_LACTION.token_t_ident, yytext(), yyline, yychar, yychar+1);}
					
case -79:
					
	break;
					
case 91:
					
	{return new Yytoken(LEX_LACTION.token_t_ident, yytext(), yyline, yychar, yychar+1);}
					
case -80:
					
	break;
					
case 93:
					
	{return new Yytoken(LEX_LACTION.token_t_ident, yytext(), yyline, yychar, yychar+1);}
					
case -81:
					
	break;
					
case 95:
					
	{return new Yytoken(LEX_LACTION.token_t_ident, yytext(), yyline, yychar, yychar+1);}
					
case -82:
					
	break;
					
case 97:
					
	{return new Yytoken(LEX_LACTION.token_t_ident, yytext(), yyline, yychar, yychar+1);}
					
case -83:
					
	break;
					
case 99:
					
	{return new Yytoken(LEX_LACTION.token_t_ident, yytext(), yyline, yychar, yychar+1);}
					
case -84:
					
	break;
					
case 101:
					
	{return new Yytoken(LEX_LACTION.token_t_ident, yytext(), yyline, yychar, yychar+1);}
					
case -85:
					
	break;
					
case 102:
					
	{return new Yytoken(LEX_LACTION.token_t_ident, yytext(), yyline, yychar, yychar+1);}
					
case -86:
					
	break;
					
case 103:
					
	{return new Yytoken(LEX_LACTION.token_t_ident, yytext(), yyline, yychar, yychar+1);}
					
case -87:
					
	break;
					
case 104:
					
	{return new Yytoken(LEX_LACTION.token_t_ident, yytext(), yyline, yychar, yychar+1);}
					
case -88:
					
	break;
					
case 105:
					
	{return new Yytoken(LEX_LACTION.token_t_ident, yytext(), yyline, yychar, yychar+1);}
					
case -89:
					
	break;
					
case 106:
					
	{return new Yytoken(LEX_LACTION.token_t_ident, yytext(), yyline, yychar, yychar+1);}
					
case -90:
					
	break;
					
case 107:
					
	{return new Yytoken(LEX_LACTION.token_t_ident, yytext(), yyline, yychar, yychar+1);}
					
case -91:
					
	break;
					
case 108:
					
	{return new Yytoken(LEX_LACTION.token_t_ident, yytext(), yyline, yychar, yychar+1);}
					
case -92:
					
	break;
					
case 109:
					
	{return new Yytoken(LEX_LACTION.token_t_ident, yytext(), yyline, yychar, yychar+1);}
					
case -93:
					
	break;
					
case 112:
					
	{return new Yytoken(LEX_LACTION.token_t_ident, yytext(), yyline, yychar, yychar+1);}
					
case -94:
					
	break;
					
case 114:
					
	{return new Yytoken(LEX_LACTION.token_t_ident, yytext(), yyline, yychar, yychar+1);}
					
case -95:
					
	break;
					
case 115:
					
	{return new Yytoken(LEX_LACTION.token_t_ident, yytext(), yyline, yychar, yychar+1);}
					
case -96:
					
	break;
					
case 116:
					
	{return new Yytoken(LEX_LACTION.token_t_ident, yytext(), yyline, yychar, yychar+1);}
					
case -97:
					
	break;
					
case 117:
					
	{return new Yytoken(LEX_LACTION.token_t_ident, yytext(), yyline, yychar, yychar+1);}
					
case -98:
					
	break;
					
case 118:
					
	{return new Yytoken(LEX_LACTION.token_t_ident, yytext(), yyline, yychar, yychar+1);}
					
case -99:
					
	break;
					
case 119:
					
	{return new Yytoken(LEX_LACTION.token_t_ident, yytext(), yyline, yychar, yychar+1);}
					
case -100:
					
	break;
					
case 120:
					
	{return new Yytoken(LEX_LACTION.token_t_ident, yytext(), yyline, yychar, yychar+1);}
					
case -101:
					
	break;
					
case 121:
					
	{return new Yytoken(LEX_LACTION.token_t_ident, yytext(), yyline, yychar, yychar+1);}
					
case -102:
					
	break;
					
case 122:
					
	{return new Yytoken(LEX_LACTION.token_t_ident, yytext(), yyline, yychar, yychar+1);}
					
case -103:
					
	break;
					
case 123:
					
	{return new Yytoken(LEX_LACTION.token_t_ident, yytext(), yyline, yychar, yychar+1);}
					
case -104:
					
	break;
					
case 124:
					
	{return new Yytoken(LEX_LACTION.token_t_ident, yytext(), yyline, yychar, yychar+1);}
					
case -105:
					
	break;
					
case 125:
					
	{return new Yytoken(LEX_LACTION.token_t_ident, yytext(), yyline, yychar, yychar+1);}
					
case -106:
					
	break;
					
case 126:
					
	{return new Yytoken(LEX_LACTION.token_t_ident, yytext(), yyline, yychar, yychar+1);}
					
case -107:
					
	break;
					
case 127:
					
	{return new Yytoken(LEX_LACTION.token_t_ident, yytext(), yyline, yychar, yychar+1);}
					
case -108:
					
	break;
					
case 128:
					
	{return new Yytoken(LEX_LACTION.token_t_ident, yytext(), yyline, yychar, yychar+1);}
					
case -109:
					
	break;
					
case 129:
					
	{return new Yytoken(LEX_LACTION.token_t_ident, yytext(), yyline, yychar, yychar+1);}
					
case -110:
					
	break;
					
case 130:
					
	{return new Yytoken(LEX_LACTION.token_t_ident, yytext(), yyline, yychar, yychar+1);}
					
case -111:
					
	break;
					
case 131:
					
	{return new Yytoken(LEX_LACTION.token_t_ident, yytext(), yyline, yychar, yychar+1);}
					
case -112:
					
	break;
					
case 132:
					
	{return new Yytoken(LEX_LACTION.token_t_ident, yytext(), yyline, yychar, yychar+1);}
					
case -113:
					
	break;
					
case 133:
					
	{return new Yytoken(LEX_LACTION.token_t_ident, yytext(), yyline, yychar, yychar+1);}
					
case -114:
					
	break;
					
case 135:
					
	{return new Yytoken(LEX_LACTION.token_t_ident, yytext(), yyline, yychar, yychar+1);}
					
case -115:
					
	break;
					
case 137:
					
	{return new Yytoken(LEX_LACTION.token_t_ident, yytext(), yyline, yychar, yychar+1);}
					
case -116:
					
	break;
					
case 138:
					
	{return new Yytoken(LEX_LACTION.token_t_ident, yytext(), yyline, yychar, yychar+1);}
					
case -117:
					
	break;
					
case 139:
					
	{return new Yytoken(LEX_LACTION.token_t_ident, yytext(), yyline, yychar, yychar+1);}
					
case -118:
					
	break;
					
case 140:
					
	{return new Yytoken(LEX_LACTION.token_t_ident, yytext(), yyline, yychar, yychar+1);}
					
case -119:
					
	break;
					
case 141:
					
	{return new Yytoken(LEX_LACTION.token_t_ident, yytext(), yyline, yychar, yychar+1);}
					
case -120:
					
	break;
					
case 142:
					
	{return new Yytoken(LEX_LACTION.token_t_ident, yytext(), yyline, yychar, yychar+1);}
					
case -121:
					
	break;
					
case 143:
					
	{return new Yytoken(LEX_LACTION.token_t_ident, yytext(), yyline, yychar, yychar+1);}
					
case -122:
					
	break;
					
case 144:
					
	{return new Yytoken(LEX_LACTION.token_t_ident, yytext(), yyline, yychar, yychar+1);}
					
case -123:
					
	break;
					
case 145:
					
	{return new Yytoken(LEX_LACTION.token_t_ident, yytext(), yyline, yychar, yychar+1);}
					
case -124:
					
	break;
					
case 146:
					
	{return new Yytoken(LEX_LACTION.token_t_ident, yytext(), yyline, yychar, yychar+1);}
					
case -125:
					
	break;
					
case 147:
					
	{return new Yytoken(LEX_LACTION.token_t_ident, yytext(), yyline, yychar, yychar+1);}
					
case -126:
					
	break;
					
case 148:
					
	{return new Yytoken(LEX_LACTION.token_t_ident, yytext(), yyline, yychar, yychar+1);}
					
case -127:
					
	break;
					
case 149:
					
	{return new Yytoken(LEX_LACTION.token_t_ident, yytext(), yyline, yychar, yychar+1);}
					
case -128:
					
	break;
					
case 150:
					
	{return new Yytoken(LEX_LACTION.token_t_ident, yytext(), yyline, yychar, yychar+1);}
					
case -129:
					
	break;
					
case 152:
					
	{return new Yytoken(LEX_LACTION.token_t_ident, yytext(), yyline, yychar, yychar+1);}
					
case -130:
					
	break;
					
case 153:
					
	{return new Yytoken(LEX_LACTION.token_t_ident, yytext(), yyline, yychar, yychar+1);}
					
case -131:
					
	break;
					
case 154:
					
	{return new Yytoken(LEX_LACTION.token_t_ident, yytext(), yyline, yychar, yychar+1);}
					
case -132:
					
	break;
					
case 155:
					
	{return new Yytoken(LEX_LACTION.token_t_ident, yytext(), yyline, yychar, yychar+1);}
					
case -133:
					
	break;
					
case 156:
					
	{return new Yytoken(LEX_LACTION.token_t_ident, yytext(), yyline, yychar, yychar+1);}
					
case -134:
					
	break;
					
case 157:
					
	{return new Yytoken(LEX_LACTION.token_t_ident, yytext(), yyline, yychar, yychar+1);}
					
case -135:
					
	break;
					
case 158:
					
	{return new Yytoken(LEX_LACTION.token_t_ident, yytext(), yyline, yychar, yychar+1);}
					
case -136:
					
	break;
					
case 159:
					
	{return new Yytoken(LEX_LACTION.token_t_ident, yytext(), yyline, yychar, yychar+1);}
					
case -137:
					
	break;
					
case 160:
					
	{return new Yytoken(LEX_LACTION.token_t_ident, yytext(), yyline, yychar, yychar+1);}
					
case -138:
					
	break;
					
case 161:
					
	{return new Yytoken(LEX_LACTION.token_t_ident, yytext(), yyline, yychar, yychar+1);}
					
case -139:
					
	break;
					
case 162:
					
	{return new Yytoken(LEX_LACTION.token_t_ident, yytext(), yyline, yychar, yychar+1);}
					
case -140:
					
	break;
					
case 163:
					
	{return new Yytoken(LEX_LACTION.token_t_ident, yytext(), yyline, yychar, yychar+1);}
					
case -141:
					
	break;
					
case 164:
					
	{return new Yytoken(LEX_LACTION.token_t_ident, yytext(), yyline, yychar, yychar+1);}
					
case -142:
					
	break;
					
case 165:
					
	{return new Yytoken(LEX_LACTION.token_t_ident, yytext(), yyline, yychar, yychar+1);}
					
case -143:
					
	break;
					
case 166:
					
	{return new Yytoken(LEX_LACTION.token_t_ident, yytext(), yyline, yychar, yychar+1);}
					
case -144:
					
	break;
					
case 167:
					
	{return new Yytoken(LEX_LACTION.token_t_ident, yytext(), yyline, yychar, yychar+1);}
					
case -145:
					
	break;
					
case 168:
					
	{return new Yytoken(LEX_LACTION.token_t_ident, yytext(), yyline, yychar, yychar+1);}
					
case -146:
					
	break;
					
case 169:
					
	{return new Yytoken(LEX_LACTION.token_t_ident, yytext(), yyline, yychar, yychar+1);}
					
case -147:
					
	break;
					
case 170:
					
	{return new Yytoken(LEX_LACTION.token_t_ident, yytext(), yyline, yychar, yychar+1);}
					
case -148:
					
	break;
					
case 171:
					
	{return new Yytoken(LEX_LACTION.token_t_ident, yytext(), yyline, yychar, yychar+1);}
					
case -149:
					
	break;
					
case 172:
					
	{return new Yytoken(LEX_LACTION.token_t_ident, yytext(), yyline, yychar, yychar+1);}
					
case -150:
					
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
