/* The following code was generated by JFlex 1.4.3 on 11/12/11 6:33 PM */

/**
 * Copyright 2011 Nikolche Mihajlovski
 *
 * This file is part of JAnnocessor.
 *
 * JAnnocessor is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * JAnnocessor is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with JAnnocessor.  If not, see <http://www.gnu.org/licenses/>.
 */

package org.jannocessor.syntax;

import jsyntaxpane.Token;
import jsyntaxpane.TokenType;
import jsyntaxpane.lexers.DefaultJFlexLexer;


/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.4.3
 * on 11/12/11 6:33 PM from the specification file
 * <tt>C:/java/ludvig/jannocessor-root/jannocessor-ui/src/main/resources/grammar.jflex</tt>
 */
public class JavaTemplateLexer extends DefaultJFlexLexer {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0, 0
  };

  /** 
   * Translates characters to character classes
   */
  private static final String ZZ_CMAP_PACKED = 
    "\11\0\1\1\1\3\1\0\1\1\1\2\22\0\1\1\1\55\1\11"+
    "\1\6\1\15\1\0\1\56\1\12\1\16\1\17\1\5\1\55\1\55"+
    "\1\55\1\13\1\4\12\10\1\0\1\55\1\55\1\55\2\0\1\14"+
    "\22\7\1\52\7\7\1\53\1\0\1\54\1\0\1\7\1\0\1\23"+
    "\1\41\1\24\1\43\1\27\1\36\1\26\1\46\1\32\1\7\1\25"+
    "\1\30\1\40\1\33\1\42\1\22\1\7\1\35\1\31\1\34\1\37"+
    "\1\44\1\51\1\50\1\45\1\47\1\20\1\0\1\21\uff82\0";

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\0\4\1\1\2\1\1\1\3\1\4\1\5\2\1"+
    "\1\6\1\7\1\10\1\11\17\3\1\12\1\13\1\1"+
    "\1\14\1\0\1\15\1\0\10\15\2\0\1\16\1\17"+
    "\1\0\16\3\1\20\16\3\2\14\2\0\1\21\7\15"+
    "\1\21\4\15\1\4\1\0\1\17\16\3\1\20\15\3"+
    "\1\0\3\15\1\22\6\15\1\17\20\3\1\15\1\21"+
    "\6\15\1\0\16\3\5\15\1\17\11\3\2\15\11\3";

  private static int [] zzUnpackAction() {
    int [] result = new int[205];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\57\0\136\0\215\0\274\0\57\0\353\0\u011a"+
    "\0\u0149\0\57\0\u0178\0\u01a7\0\57\0\57\0\57\0\57"+
    "\0\u01d6\0\u0205\0\u0234\0\u0263\0\u0292\0\u02c1\0\u02f0\0\u031f"+
    "\0\u034e\0\u037d\0\u03ac\0\u03db\0\u040a\0\u0439\0\u0468\0\57"+
    "\0\57\0\u0497\0\u04c6\0\u04f5\0\u0524\0\u0553\0\u0582\0\u05b1"+
    "\0\u05e0\0\u060f\0\u063e\0\u066d\0\u069c\0\u06cb\0\u06fa\0\u0178"+
    "\0\57\0\u0729\0\u0758\0\u0787\0\u07b6\0\u07e5\0\u0814\0\u0843"+
    "\0\u0872\0\u08a1\0\u08d0\0\u08ff\0\u092e\0\u095d\0\u098c\0\u09bb"+
    "\0\u09ea\0\u011a\0\u0a19\0\u0a48\0\u0a77\0\u0aa6\0\u0ad5\0\u0b04"+
    "\0\u0b33\0\u0b62\0\u0b91\0\u0bc0\0\u0bef\0\u0c1e\0\u0c4d\0\u0c7c"+
    "\0\u0cab\0\57\0\u0cda\0\u0d09\0\u0d38\0\u0d67\0\u0d96\0\u0dc5"+
    "\0\u0df4\0\u0e23\0\u0e52\0\u0e81\0\u0524\0\u0eb0\0\u0edf\0\u0f0e"+
    "\0\u0f3d\0\u06fa\0\u0f6c\0\57\0\u0f9b\0\u0fca\0\u0ff9\0\u1028"+
    "\0\u1057\0\u1086\0\u10b5\0\u10e4\0\u1113\0\u1142\0\u1171\0\u11a0"+
    "\0\u11cf\0\u11fe\0\u122d\0\u125c\0\u128b\0\u12ba\0\u12e9\0\u1318"+
    "\0\u1347\0\u1376\0\u13a5\0\u13d4\0\u1403\0\u1432\0\u1461\0\u1490"+
    "\0\u14bf\0\u14ee\0\u151d\0\u154c\0\u0524\0\u157b\0\u15aa\0\u15d9"+
    "\0\u1608\0\u1637\0\u1666\0\u1695\0\u16c4\0\u16f3\0\u1722\0\u1751"+
    "\0\u1780\0\u17af\0\u17de\0\u180d\0\u183c\0\u186b\0\u189a\0\u18c9"+
    "\0\u18f8\0\u1927\0\u1956\0\u1985\0\u19b4\0\u19e3\0\u1a12\0\u1a41"+
    "\0\u1a70\0\u1a9f\0\u1ace\0\u1afd\0\u1b2c\0\u1b5b\0\u1b8a\0\u1bb9"+
    "\0\u1be8\0\u1c17\0\u1c46\0\u1c75\0\u1ca4\0\u1cd3\0\u1d02\0\u1d31"+
    "\0\u1d60\0\u1d8f\0\u1dbe\0\u1ded\0\u1e1c\0\u1e4b\0\u1e7a\0\u1ea9"+
    "\0\u1ed8\0\u1f07\0\u1f36\0\u1f65\0\u1f94\0\u1fc3\0\u1ff2\0\u2021"+
    "\0\u2050\0\u207f\0\u20ae\0\u20dd\0\u210c\0\u213b\0\u216a\0\u2199"+
    "\0\u21c8\0\u21f7\0\u2226\0\u2255\0\u2284";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[205];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\2\1\3\1\4\1\2\1\5\1\6\1\7\1\10"+
    "\1\11\1\12\1\13\1\6\1\2\1\14\1\15\1\16"+
    "\1\17\1\20\1\21\1\22\1\23\2\10\1\24\1\25"+
    "\1\26\1\27\1\30\1\31\1\10\1\32\2\10\1\33"+
    "\1\10\1\34\1\35\4\10\1\36\1\37\1\40\1\41"+
    "\1\6\1\42\60\0\1\3\60\0\1\2\57\0\1\43"+
    "\1\44\57\0\1\43\1\45\4\0\1\46\5\0\1\47"+
    "\4\45\1\50\1\45\1\51\1\52\3\45\1\53\1\45"+
    "\1\54\1\55\1\45\1\56\7\45\13\0\2\10\11\0"+
    "\31\10\14\0\1\11\2\0\1\57\43\0\2\60\2\0"+
    "\6\60\1\61\44\60\7\0\1\62\10\0\1\63\1\0"+
    "\31\62\13\0\2\10\11\0\1\10\1\64\11\10\1\65"+
    "\1\10\1\66\13\10\13\0\2\10\11\0\17\10\1\67"+
    "\11\10\13\0\2\10\11\0\1\10\1\70\4\10\1\71"+
    "\15\10\1\72\4\10\13\0\2\10\11\0\6\10\1\70"+
    "\2\10\1\73\14\10\1\74\2\10\13\0\2\10\11\0"+
    "\20\10\1\75\10\10\13\0\2\10\11\0\12\10\1\76"+
    "\10\10\1\77\3\10\1\100\1\10\13\0\2\10\11\0"+
    "\11\10\1\101\2\10\1\102\1\10\1\103\12\10\13\0"+
    "\2\10\11\0\5\10\1\104\7\10\1\105\13\10\13\0"+
    "\2\10\11\0\13\10\1\106\10\10\1\107\4\10\13\0"+
    "\2\10\11\0\1\10\1\110\6\10\1\111\7\10\1\112"+
    "\10\10\13\0\2\10\11\0\20\10\1\113\10\10\13\0"+
    "\2\10\11\0\5\10\1\114\12\10\1\115\10\10\13\0"+
    "\2\10\11\0\20\10\1\116\10\10\13\0\2\10\11\0"+
    "\24\10\1\117\4\10\13\0\2\10\11\0\12\10\1\120"+
    "\16\10\62\0\1\6\2\43\1\121\1\122\53\43\5\123"+
    "\1\124\51\123\7\0\2\45\11\0\31\45\13\0\1\125"+
    "\12\0\31\125\13\0\2\45\11\0\1\45\1\126\27\45"+
    "\13\0\2\45\11\0\6\45\1\127\2\45\1\130\10\45"+
    "\1\131\6\45\13\0\2\45\11\0\5\45\1\132\4\45"+
    "\1\133\16\45\13\0\2\45\11\0\11\45\1\134\2\45"+
    "\1\135\14\45\13\0\2\45\11\0\20\45\1\136\10\45"+
    "\13\0\2\45\11\0\1\45\1\137\27\45\13\0\2\45"+
    "\11\0\13\45\1\140\15\45\13\0\2\45\11\0\5\45"+
    "\1\141\23\45\14\0\1\142\55\0\2\62\2\0\1\143"+
    "\6\0\31\62\4\0\21\63\1\144\35\63\7\0\2\10"+
    "\11\0\2\10\1\145\26\10\13\0\2\10\11\0\10\10"+
    "\1\146\7\10\1\147\10\10\13\0\2\10\11\0\17\10"+
    "\1\150\11\10\13\0\2\10\11\0\7\10\1\151\21\10"+
    "\13\0\2\10\11\0\7\10\1\152\21\10\13\0\2\10"+
    "\11\0\1\10\1\153\27\10\13\0\2\10\11\0\1\10"+
    "\1\112\27\10\13\0\2\10\11\0\15\10\1\154\13\10"+
    "\13\0\2\10\11\0\12\10\1\155\16\10\13\0\2\10"+
    "\11\0\11\10\1\156\17\10\13\0\2\10\11\0\1\10"+
    "\1\157\11\10\1\160\15\10\13\0\2\10\11\0\11\10"+
    "\1\161\17\10\13\0\2\10\11\0\10\10\1\162\20\10"+
    "\13\0\2\10\11\0\12\10\1\163\16\10\13\0\2\10"+
    "\11\0\1\164\30\10\13\0\2\10\11\0\27\10\1\102"+
    "\1\10\13\0\2\10\11\0\6\10\1\165\22\10\13\0"+
    "\2\10\11\0\1\10\1\166\13\10\1\152\13\10\13\0"+
    "\2\10\11\0\10\10\1\167\2\10\1\170\15\10\13\0"+
    "\2\10\11\0\6\10\1\70\22\10\13\0\2\10\11\0"+
    "\11\10\1\171\17\10\13\0\2\10\11\0\13\10\1\102"+
    "\15\10\13\0\2\10\11\0\20\10\1\172\10\10\13\0"+
    "\2\10\11\0\14\10\1\173\14\10\13\0\2\10\11\0"+
    "\15\10\1\174\13\10\13\0\2\10\11\0\6\10\1\175"+
    "\1\10\1\176\20\10\13\0\2\10\11\0\10\10\1\177"+
    "\20\10\13\0\2\10\11\0\13\10\1\200\15\10\7\0"+
    "\1\122\53\0\5\123\1\201\51\123\4\0\1\122\1\124"+
    "\60\0\2\125\11\0\31\125\13\0\2\45\11\0\13\45"+
    "\1\202\15\45\13\0\2\45\11\0\7\45\1\203\21\45"+
    "\13\0\2\45\11\0\21\45\1\135\7\45\13\0\2\45"+
    "\11\0\1\45\1\204\27\45\13\0\2\45\11\0\12\45"+
    "\1\205\16\45\13\0\2\45\11\0\20\45\1\206\10\45"+
    "\13\0\2\45\11\0\2\45\1\207\26\45\13\0\2\45"+
    "\11\0\13\45\1\210\15\45\13\0\2\45\11\0\2\45"+
    "\1\211\26\45\13\0\2\45\11\0\5\45\1\212\23\45"+
    "\13\0\2\45\11\0\14\45\1\213\14\45\13\0\1\214"+
    "\12\0\31\214\13\0\2\10\11\0\3\10\1\215\25\10"+
    "\13\0\2\10\11\0\22\10\1\216\6\10\13\0\2\10"+
    "\11\0\12\10\1\217\16\10\13\0\2\10\11\0\6\10"+
    "\1\220\22\10\13\0\2\10\11\0\12\10\1\221\16\10"+
    "\13\0\2\10\11\0\5\10\1\102\23\10\13\0\2\10"+
    "\11\0\7\10\1\167\21\10\13\0\2\10\11\0\16\10"+
    "\1\102\12\10\13\0\2\10\11\0\5\10\1\222\23\10"+
    "\13\0\2\10\11\0\4\10\1\102\24\10\13\0\2\10"+
    "\11\0\12\10\1\220\16\10\13\0\2\10\11\0\10\10"+
    "\1\223\20\10\13\0\2\10\11\0\2\10\1\224\26\10"+
    "\13\0\2\10\11\0\12\10\1\225\16\10\13\0\2\10"+
    "\11\0\5\10\1\226\23\10\13\0\2\10\11\0\6\10"+
    "\1\227\22\10\13\0\2\10\11\0\6\10\1\102\22\10"+
    "\13\0\2\10\11\0\11\10\1\230\17\10\13\0\2\10"+
    "\11\0\7\10\1\102\21\10\13\0\2\10\11\0\20\10"+
    "\1\231\10\10\13\0\2\10\11\0\1\10\1\165\27\10"+
    "\13\0\2\10\11\0\6\10\1\232\22\10\13\0\2\10"+
    "\11\0\1\10\1\233\27\10\13\0\2\10\11\0\17\10"+
    "\1\177\11\10\13\0\2\10\11\0\1\10\1\234\27\10"+
    "\13\0\2\10\11\0\21\10\1\102\7\10\13\0\2\10"+
    "\11\0\6\10\1\152\22\10\13\0\2\10\11\0\10\10"+
    "\1\75\20\10\4\0\4\123\1\122\1\201\51\123\7\0"+
    "\2\45\11\0\7\45\1\235\21\45\13\0\2\45\11\0"+
    "\5\45\1\236\23\45\13\0\2\45\11\0\6\45\1\237"+
    "\22\45\13\0\2\45\11\0\1\205\30\45\13\0\2\45"+
    "\11\0\6\45\1\240\22\45\13\0\2\45\11\0\5\45"+
    "\1\241\23\45\13\0\2\45\11\0\13\45\1\242\15\45"+
    "\13\0\2\45\11\0\1\45\1\243\27\45\13\0\2\45"+
    "\11\0\10\45\1\244\20\45\13\0\2\214\2\0\1\143"+
    "\2\0\1\245\3\0\31\214\13\0\2\10\11\0\1\10"+
    "\1\246\27\10\13\0\2\10\11\0\1\10\1\247\27\10"+
    "\13\0\2\10\11\0\5\10\1\250\23\10\13\0\2\10"+
    "\11\0\10\10\1\251\20\10\13\0\2\10\11\0\13\10"+
    "\1\252\15\10\13\0\2\10\11\0\11\10\1\253\17\10"+
    "\13\0\2\10\11\0\2\10\1\254\26\10\13\0\2\10"+
    "\11\0\24\10\1\255\4\10\13\0\2\10\11\0\2\10"+
    "\1\256\26\10\13\0\2\10\11\0\13\10\1\257\15\10"+
    "\13\0\2\10\11\0\5\10\1\260\23\10\13\0\2\10"+
    "\11\0\7\10\1\261\21\10\13\0\2\10\11\0\27\10"+
    "\1\167\1\10\13\0\2\10\11\0\5\10\1\262\23\10"+
    "\13\0\2\10\11\0\15\10\1\263\13\10\13\0\2\10"+
    "\11\0\12\10\1\117\16\10\13\0\2\45\11\0\5\45"+
    "\1\205\23\45\13\0\2\45\11\0\10\45\1\264\20\45"+
    "\13\0\2\45\11\0\15\45\1\265\13\45\13\0\2\45"+
    "\11\0\15\45\1\266\13\45\13\0\2\45\11\0\1\45"+
    "\1\267\27\45\13\0\2\45\11\0\20\45\1\135\10\45"+
    "\13\0\2\45\11\0\3\45\1\205\25\45\13\0\2\45"+
    "\11\0\11\45\1\270\17\45\4\0\16\245\1\0\1\271"+
    "\37\245\7\0\2\10\11\0\4\10\1\152\24\10\13\0"+
    "\2\10\11\0\12\10\1\152\16\10\13\0\2\10\11\0"+
    "\2\10\1\272\26\10\13\0\2\10\11\0\2\10\1\102"+
    "\26\10\13\0\2\10\11\0\1\10\1\273\27\10\13\0"+
    "\2\10\11\0\21\10\1\167\7\10\13\0\2\10\11\0"+
    "\12\10\1\274\16\10\13\0\2\10\11\0\13\10\1\275"+
    "\15\10\13\0\2\10\11\0\24\10\1\102\4\10\13\0"+
    "\2\10\11\0\14\10\1\276\14\10\13\0\2\10\11\0"+
    "\16\10\1\277\12\10\13\0\2\10\11\0\10\10\1\300"+
    "\20\10\13\0\2\10\11\0\1\10\1\301\27\10\13\0"+
    "\2\10\11\0\6\10\1\302\22\10\13\0\2\45\11\0"+
    "\14\45\1\135\14\45\13\0\2\45\11\0\1\45\1\303"+
    "\27\45\13\0\2\45\11\0\21\45\1\235\7\45\13\0"+
    "\2\45\11\0\2\45\1\304\26\45\13\0\2\45\11\0"+
    "\5\45\1\135\23\45\17\0\1\143\52\0\2\10\11\0"+
    "\12\10\1\305\16\10\13\0\2\10\11\0\2\10\1\302"+
    "\26\10\13\0\2\10\11\0\14\10\1\306\14\10\13\0"+
    "\2\10\11\0\20\10\1\307\10\10\13\0\2\10\11\0"+
    "\1\10\1\310\27\10\13\0\2\10\11\0\5\10\1\311"+
    "\23\10\13\0\2\10\11\0\5\10\1\312\23\10\13\0"+
    "\2\10\11\0\11\10\1\102\17\10\13\0\2\10\11\0"+
    "\12\10\1\102\16\10\13\0\2\45\11\0\12\45\1\235"+
    "\16\45\13\0\2\45\11\0\24\45\1\135\4\45\13\0"+
    "\2\10\11\0\5\10\1\176\23\10\13\0\2\10\11\0"+
    "\1\102\30\10\13\0\2\10\11\0\11\10\1\313\17\10"+
    "\13\0\2\10\11\0\2\10\1\152\26\10\13\0\2\10"+
    "\11\0\11\10\1\314\17\10\13\0\2\10\11\0\11\10"+
    "\1\302\17\10\13\0\2\10\11\0\10\10\1\315\20\10"+
    "\13\0\2\10\11\0\12\10\1\167\16\10\13\0\2\10"+
    "\11\0\25\10\1\305\3\10\4\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[8883];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String ZZ_ERROR_MSG[] = {
    "Unkown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\1\0\1\11\3\1\1\11\3\1\1\11\2\1\4\11"+
    "\17\1\2\11\2\1\1\0\1\1\1\0\10\1\2\0"+
    "\1\11\1\1\1\0\36\1\1\11\2\0\16\1\1\0"+
    "\1\11\34\1\1\0\43\1\1\0\50\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[205];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private char zzBuffer[] = new char[ZZ_BUFFERSIZE];

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /** number of newlines encountered up to the start of the matched text */
  private int yyline;

  /** the number of characters up to the start of the matched text */
  private int yychar;

  /**
   * the number of characters from the last newline up to the start of the 
   * matched text
   */
  private int yycolumn;

  /** 
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;

  /* user code: */
    public JavaTemplateLexer() {
        super();
    }

    public Token token(TokenType type) {
        return new Token(type, yychar, yylength());
    }

    public Token token(TokenType type, int pairValue) {
        return new Token(type, yychar, yylength(), (byte)pairValue);
    }

	@Override
	public int yychar() {
		return yychar;
	}



  /**
   * Creates a new scanner
   * There is also a java.io.InputStream version of this constructor.
   *
   * @param   in  the java.io.Reader to read input from.
   */
  public JavaTemplateLexer(java.io.Reader in) {
    this.zzReader = in;
  }

  /**
   * Creates a new scanner.
   * There is also java.io.Reader version of this constructor.
   *
   * @param   in  the java.io.Inputstream to read input from.
   */
  public JavaTemplateLexer(java.io.InputStream in) {
    this(new java.io.InputStreamReader(in));
  }

  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    char [] map = new char[0x10000];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < 138) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }


  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   * 
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead-zzStartRead);

      /* translate stored positions */
      zzEndRead-= zzStartRead;
      zzCurrentPos-= zzStartRead;
      zzMarkedPos-= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length) {
      /* if not: blow it up */
      char newBuffer[] = new char[zzCurrentPos*2];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
    }

    /* finally: fill the buffer with new input */
    int numRead = zzReader.read(zzBuffer, zzEndRead,
                                            zzBuffer.length-zzEndRead);

    if (numRead > 0) {
      zzEndRead+= numRead;
      return false;
    }
    // unlikely but not impossible: read 0 characters, but not at end of stream    
    if (numRead == 0) {
      int c = zzReader.read();
      if (c == -1) {
        return true;
      } else {
        zzBuffer[zzEndRead++] = (char) c;
        return false;
      }     
    }

	// numRead < 0
    return true;
  }

    
  /**
   * Closes the input stream.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true;            /* indicate end of file */
    zzEndRead = zzStartRead;  /* invalidate buffer    */

    if (zzReader != null)
      zzReader.close();
  }


  /**
   * Resets the scanner to read from a new input stream.
   * Does not close the old reader.
   *
   * All internal variables are reset, the old input stream 
   * <b>cannot</b> be reused (internal buffer is discarded and lost).
   * Lexical state is set to <tt>ZZ_INITIAL</tt>.
   *
   * @param reader   the new input stream 
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzAtBOL  = true;
    zzAtEOF  = false;
    zzEOFDone = false;
    zzEndRead = zzStartRead = 0;
    zzCurrentPos = zzMarkedPos = 0;
    yyline = yychar = yycolumn = 0;
    zzLexicalState = YYINITIAL;
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final String yytext() {
    return new String( zzBuffer, zzStartRead, zzMarkedPos-zzStartRead );
  }


  /**
   * Returns the character at position <tt>pos</tt> from the 
   * matched text. 
   * 
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch. 
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer[zzStartRead+pos];
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of 
   * yypushback(int) and a match-all fallback rule) this method 
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  } 


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public Token yylex() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char [] zzBufferL = zzBuffer;
    char [] zzCMapL = ZZ_CMAP;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      yychar+= zzMarkedPosL-zzStartRead;

      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;
  
      zzState = ZZ_LEXSTATE[zzLexicalState];


      zzForAction: {
        while (true) {
    
          if (zzCurrentPosL < zzEndReadL)
            zzInput = zzBufferL[zzCurrentPosL++];
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = zzBufferL[zzCurrentPosL++];
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMapL[zzInput] ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          int zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
        case 16: 
          { return token(TokenType.KEYWORD);
          }
        case 19: break;
        case 4: 
          { return token(TokenType.NUMBER);
          }
        case 20: break;
        case 6: 
          { return token(TokenType.OPERATOR, 30);
          }
        case 21: break;
        case 2: 
          { return token(TokenType.OPERATOR);
          }
        case 22: break;
        case 15: 
          { return token(TokenType.TYPE3);
          }
        case 23: break;
        case 5: 
          { return token(TokenType.STRING);
          }
        case 24: break;
        case 18: 
          { return token(TokenType.TYPE);
          }
        case 25: break;
        case 9: 
          { return token(TokenType.OPERATOR, -10);
          }
        case 26: break;
        case 3: 
          { return token(TokenType.IDENTIFIER);
          }
        case 27: break;
        case 17: 
          { return token(TokenType.KEYWORD2);
          }
        case 28: break;
        case 13: 
          { return token(TokenType.TYPE2);
          }
        case 29: break;
        case 11: 
          { return token(TokenType.OPERATOR, -20);
          }
        case 30: break;
        case 12: 
          { return token(TokenType.COMMENT);
          }
        case 31: break;
        case 8: 
          { return token(TokenType.OPERATOR, 10);
          }
        case 32: break;
        case 14: 
          { return token(TokenType.STRING2);
          }
        case 33: break;
        case 7: 
          { return token(TokenType.OPERATOR, -30);
          }
        case 34: break;
        case 1: 
          { 
          }
        case 35: break;
        case 10: 
          { return token(TokenType.OPERATOR, 20);
          }
        case 36: break;
        default: 
          if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
            zzAtEOF = true;
              {
                return null;
              }
          } 
          else {
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}
