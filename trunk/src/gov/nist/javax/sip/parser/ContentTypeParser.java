/*
* Conditions Of Use 
* 
* This software was developed by employees of the National Institute of
* Standards and Technology (NIST), an agency of the Federal Government.
* Pursuant to title 15 Untied States Code Section 105, works of NIST
* employees are not subject to copyright protection in the United States
* and are considered to be in the public domain.  As a result, a formal
* license is not needed to use the software.
* 
* This software is provided by NIST as a service and is expressly
* provided "AS IS."  NIST MAKES NO WARRANTY OF ANY KIND, EXPRESS, IMPLIED
* OR STATUTORY, INCLUDING, WITHOUT LIMITATION, THE IMPLIED WARRANTY OF
* MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE, NON-INFRINGEMENT
* AND DATA ACCURACY.  NIST does not warrant or make any representations
* regarding the use of the software or the results thereof, including but
* not limited to the correctness, accuracy, reliability or usefulness of
* the software.
* 
* Permission to use this software is contingent upon your acceptance
* of the terms of this agreement
*  
* .
* 
*/
/*
 * ContentTypeParser.java
 *
 * Created on February 26, 2002, 2:42 PM
 */

package gov.nist.javax.sip.parser;
import gov.nist.core.*;
import gov.nist.javax.sip.header.*;
import java.text.ParseException;

/**
 * Parser for content type header.
 *
 * @version 1.2 $Revision: 1.7 $ $Date: 2006-07-13 09:02:01 $
 *
 * @author M. Ranganathan   <br/>
 *
 *
 */
public class ContentTypeParser extends ParametersParser {

	public ContentTypeParser(String contentType) {
		super(contentType);
	}

	protected ContentTypeParser(Lexer lexer) {
		super(lexer);
	}

	public SIPHeader parse() throws ParseException {

		ContentType contentType = new ContentType();
		if (debug)
			dbg_enter("ContentTypeParser.parse");

		try {
			this.headerName(TokenTypes.CONTENT_TYPE);

			// The type:
			lexer.match(TokenTypes.ID);
			Token type = lexer.getNextToken();
			this.lexer.SPorHT();
			contentType.setContentType(type.getTokenValue());

			// The sub-type:
			lexer.match('/');
			lexer.match(TokenTypes.ID);
			Token subType = lexer.getNextToken();
			this.lexer.SPorHT();
			contentType.setContentSubType(subType.getTokenValue());
			super.parse(contentType);
			this.lexer.match('\n');
		} finally {
			if (debug)
				dbg_leave("ContentTypeParser.parse");
		}
		return contentType;

	}

	
}
/*
 * $Log: not supported by cvs2svn $
 * Revision 1.3  2006/06/19 06:47:27  mranga
 * javadoc fixups
 *
 * Revision 1.2  2006/06/16 15:26:28  mranga
 * Added NIST disclaimer to all public domain files. Clean up some javadoc. Fixed a leak
 *
 * Revision 1.1.1.1  2005/10/04 17:12:35  mranga
 *
 * Import
 *
 *
 * Revision 1.5  2004/07/28 14:13:55  mranga
 * Submitted by:  mranga
 *
 * Move out the test code to a separate test/unit class.
 * Fixed some encode methods.
 *
 * Revision 1.4  2004/01/22 13:26:31  sverker
 * Issue number:
 * Obtained from:
 * Submitted by:  sverker
 * Reviewed by:   mranga
 *
 * Major reformat of code to conform with style guide. Resolved compiler and javadoc warnings. Added CVS tags.
 *
 * CVS: ----------------------------------------------------------------------
 * CVS: Issue number:
 * CVS:   If this change addresses one or more issues,
 * CVS:   then enter the issue number(s) here.
 * CVS: Obtained from:
 * CVS:   If this change has been taken from another system,
 * CVS:   then name the system in this line, otherwise delete it.
 * CVS: Submitted by:
 * CVS:   If this code has been contributed to the project by someone else; i.e.,
 * CVS:   they sent us a patch or a set of diffs, then include their name/email
 * CVS:   address here. If this is your work then delete this line.
 * CVS: Reviewed by:
 * CVS:   If we are doing pre-commit code reviews and someone else has
 * CVS:   reviewed your changes, include their name(s) here.
 * CVS:   If you have not had it reviewed then delete this line.
 *
 */
