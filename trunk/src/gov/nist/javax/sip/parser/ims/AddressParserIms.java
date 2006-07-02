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
/*******************************************
 * PRODUCT OF PT INOVAO - EST DEPARTMENT *
 *******************************************/

package gov.nist.javax.sip.parser.ims;

import java.text.ParseException;

import gov.nist.javax.sip.address.AddressImpl;
import gov.nist.javax.sip.header.ims.AddressHeader;
import gov.nist.javax.sip.parser.HeaderParser;
import gov.nist.javax.sip.parser.Lexer;
import gov.nist.javax.sip.parser.AddressParser;

/**
 * @author ALEXANDRE MIGUEL SILVA SANTOS - Nú 10045401
 */

public class AddressParserIms extends HeaderParser {
	
	protected AddressParserIms(Lexer lexer) {
		super(lexer);
	}

	protected AddressParserIms(String buffer) {
		super(buffer);
	}
	
	protected void parse(AddressHeader addressHeader)
	throws ParseException {
	dbg_enter("AddressParserIms.parse");
	try {
		AddressParser addressParser = new AddressParser(this.getLexer());
		AddressImpl addr = addressParser.address();
		addressHeader.setAddress(addr);
		
		
	
	} catch (ParseException ex) {
		throw ex;
	} finally {
		dbg_leave("AddressParserIms.parse");
	}
}

}
