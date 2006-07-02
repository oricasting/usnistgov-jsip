/*
* Conditions Of Use 
* 
* This software was developed by employees of the National Institute of
* Standards and Technology (NIST), and others. 
* This software is has been contributed to the public domain. 
* As a result, a formal license is not needed to use the software.
* 
* This software is provided "AS IS."  
* NIST MAKES NO WARRANTY OF ANY KIND, EXPRESS, IMPLIED
* OR STATUTORY, INCLUDING, WITHOUT LIMITATION, THE IMPLIED WARRANTY OF
* MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE, NON-INFRINGEMENT
* AND DATA ACCURACY.  NIST does not warrant or make any representations
* regarding the use of the software or the results thereof, including but
* not limited to the correctness, accuracy, reliability or usefulness of
* the software.
* 
* 
*/
/*
 * Created on Jul 27, 2004
 *
 *The JAIN-SIP project
 */
package test.unit.gov.nist.javax.sip.parser;

import gov.nist.javax.sip.parser.ContactParser;

/**
 * Test case for contact parser
 * 
 * @author mranga
 */
public class ContactParserTest extends ParserTestCase {

	public void testParser() {

		String contact[] = {
				"Contact:<sip:utente@127.0.0.1:5000;transport=udp>;expires=3600\n",
				"Contact:BigGuy<sip:utente@127.0.0.1:5000>;expires=3600\n",
				"Contact: sip:4855@166.35.224.216:5060\n",
				"Contact: sip:user@host.company.com\n",
				"Contact: Bo Bob Biggs\n"
						+ "< sip:user@example.com?Route=%3Csip:sip.example.com%3E >\n",
				"Contact: Joe Bob Briggs <sip:mranga@nist.gov>\n",
				"Contact: \"Mr. Watson\" <sip:watson@worcester.bell-telephone.com>"
						+ " ; q=0.7; expires=3600,\"Mr. Watson\" <mailto:watson@bell-telephone.com>"
						+ ";q=0.1\n",
				"Contact: LittleGuy <sip:UserB@there.com;user=phone>"
						+ ",<sip:+1-972-555-2222@gw1.wcom.com;user=phone>,tel:+1-972-555-2222"
						+ "\n",
				"Contact:*\n",
				"Contact:BigGuy<sip:utente@127.0.0.1;5000>;Expires=3600\n" ,
				"Contact: sip:nobody@192.168.0.241;expires=600;q=0.5\n"};
		super.testParser(ContactParser.class, contact);

	}

}