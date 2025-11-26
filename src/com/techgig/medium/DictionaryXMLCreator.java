package com.techgig.medium;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DictionaryXMLCreator {

	public static void main(String[] args) throws IOException {
		//		String fileName = "/Users/abhilashkumar.ks/Desktop/Fields to generate dictionary.csv";
		//		BufferedReader br = new BufferedReader(new FileReader(fileName));
		//		String line;
		//		Set<String> columnSet = new HashSet<>();
		//		String dictFileName = "/Users/abhilashkumar.ks/Desktop/Dictionary.xml";
		//		BufferedWriter bw = new BufferedWriter(new FileWriter(dictFileName,true));
		//		
		//		while ((line = br.readLine()) != null) {
		//			
		//			String[] lineSplit = line.split(",");
		//
		//			if(columnSet.isEmpty() || !columnSet.contains(lineSplit[1])) {
		//				Dict d = new Dict(lineSplit[0], lineSplit[1], lineSplit[2]);
		//				String xmlData = getXMLElement(d);
		//				
		//				bw.write(xmlData+"\n");
		//			}
		//		}
		//		
		//		bw.flush();
		String xmlString = "<sn_bom_credit_card_disputes_intake>\n"
				+ "	<element label=\"Type\" max_length=\"8\" name=\"type\" type=\"choice\" choice=\"1\">\n"
				+ "		<choice>\n"
				+ "			<element label=\"Dispute request\" sequence=\"0\" value=\"DISPREQ\"/>\n"
				+ "			<element label=\"Dispute response\" sequence=\"1\" value=\"DISPRESP\"/>\n"
				+ "			<element label=\"Pre-arbitration request\" sequence=\"1\" value=\"PA\"/>\n"
				+ "			<element label=\"Pre-arbitration response\" sequence=\"1\" value=\"PAR\"/>\n"
				+ "			<element label=\"Arbitration\" sequence=\"1\" value=\"ARBT\"/>\n"
				+ "		</choice>\n"
				+ "	</element>\n"
				+ "	<element label=\"Dispute Task\" max_length=\"32\" name=\"dispute_task\" reference=\"sn_bom_credit_card_task\" reference_cascade_rule=\"cascade\" type=\"reference\"/>\n"
				+ "	<element label=\"Dispute response\" max_length=\"8\" name=\"dispute_response\" type=\"choice\" choice=\"1\">\n"
				+ "		<choice>\n"
				+ "			<element label=\"Accept Full\" sequence=\"0\" value=\"FULL\"/>\n"
				+ "			<element label=\"Accept Partial\" sequence=\"1\" value=\"PART\"/>\n"
				+ "			<element label=\"Decline\" sequence=\"2\" value=\"DECL\"/>\n"
				+ "		</choice>\n"
				+ "	</element>\n"
				+ "	<element label=\"Dispute response reason\" max_length=\"8\" name=\"dispute_response_reason\" type=\"choice\" choice=\"1\">\n"
				+ "		<choice>\n"
				+ "			<element label=\"Cardholder No Longer Disputes\" sequence=\"0\" value=\"CNLD\"/>\n"
				+ "			<element label=\"Credit or Reversal Processed\" sequence=\"1\" value=\"CP\"/>\n"
				+ "			<element label=\"Reversal issued by merchant\" sequence=\"2\" value=\"RM\"/>\n"
				+ "			<element label=\"Copy of ATM Cash Disbursement or Load Transaction\" sequence=\"3\" value=\"CDLT\"/>\n"
				+ "			<element label=\"Invalid Dispute\" sequence=\"4\" value=\"ID\"/>\n"
				+ "			<element label=\"Non-fiat currency or non-fungible token\" sequence=\"5\" value=\"FC\"/>\n"
				+ "			<element label=\"Not listed Above\" sequence=\"6\" value=\"NL\"/>\n"
				+ "		</choice>\n"
				+ "	</element>\n"
				+ "	<element label=\"Dispute response reason explanation\" max_length=\"10000\" name=\"dispute_response_reason_explanation\" type=\"string\"/>\n"
				+ "	<element label=\"What cancellation date did the cardholder request?\" max_length=\"8\" name=\"cardholder_requested_cancellation_date\" type=\"glide_date\"/>\n"
				+ "	<element label=\"Transactions involving the acquisition of non-fiat currency or purchase of non-\" max_length=\"1\" name=\"transaction_matching\" type=\"choice\" choice=\"1\">\n"
				+ "		<choice>\n"
				+ "			<element label=\"Yes\" sequence=\"0\" value=\"Y\"/>\n"
				+ "			<element label=\"No\" sequence=\"1\" value=\"N\"/>\n"
				+ "		</choice>\n"
				+ "	</element>\n"
				+ "	<element label=\"Why are you not accepting full liability?\" max_length=\"10000\" name=\"liability_not_accepted_fully\" type=\"string\"/>\n"
				+ "	<element label=\"Dispute is invalid because\" max_length=\"250\" name=\"DisputeInvalidReason\" type=\"string\">\n"
				+ "		<element value=\"IDRP1\" sequence=\"0\" label=\"Transaction code is correct\"/>\n"
				+ "		<element value=\"IDRP2\" sequence=\"1\" label=\"Credit was processed correctly\"/>\n"
				+ "		<element value=\"IDRP3\" sequence=\"2\" label=\"Currency is correct\"/>\n"
				+ "		<element value=\"IDRP4\" sequence=\"3\" label=\"Country code is correct\"/>\n"
				+ "		<element value=\"IDRC1\" sequence=\"4\" label=\"Services or merchandise were provided prior to cancellation date\"/>\n"
				+ "		<element value=\"IDRC2\" sequence=\"5\" label=\"Acquirer or merchant was not notified that the account was closed\"/>\n"
				+ "		<element value=\"IDRC3\" sequence=\"6\" label=\"Cardholder requested cancellation for a different date and the services were provided until that date\"/>\n"
				+ "		<element value=\"IDRC4\" sequence=\"7\" label=\"Cardholder cancelled before the expected receipt date of the merchandise/services\"/>\n"
				+ "		<element value=\"IDRC5\" sequence=\"8\" label=\"Merchandise being held at cardholder's custom agency\"/>\n"
				+ "		<element value=\"IDRC6\" sequence=\"9\" label=\"Balance of a partial prepayment was not paid and the merchant was willing and able to provide merchandise/services\"/>\n"
				+ "		<element value=\"IDRC7\" sequence=\"10\" label=\"Cardholder received merchandise at the agreed upon location or by the agreed date/time\"/>\n"
				+ "		<element value=\"IDRC8\" sequence=\"11\" label=\"Name on manifest of departed flight matches name on purchased itinerary\"/>\n"
				+ "		<element value=\"IDRC9\" sequence=\"12\" label=\"Disputed amount is due to Value Added Tax\"/>\n"
				+ "		<element value=\"IDRC10\" sequence=\"13\" label=\"Returned Merchandise is being held in a custom agency outside the merchants country\"/>\n"
				+ "		<element value=\"IDRC11\" sequence=\"14\" label=\"Merchandise or Service matched what was described\"/>\n"
				+ "		<element value=\"IDRC12\" sequence=\"15\" label=\"Merchandise was not damaged\"/>\n"
				+ "		<element value=\"IDRC13\" sequence=\"16\" label=\"Merchandise or Service was not defective\"/>\n"
				+ "		<element value=\"IDRC14\" sequence=\"17\" label=\"Merchandise or Service quality matched what was described\"/>\n"
				+ "		<element value=\"IDRC15\" sequence=\"18\" label=\"Dispute is for the cash back portion of a Visa Cash Back Transaction\"/>\n"
				+ "		<element value=\"IDRC16\" sequence=\"19\" label=\"Dispute is for quality and services and there was no credit receipt provided\"/>\n"
				+ "		<element value=\"IDRC17\" sequence=\"20\" label=\"Disputed amount is a Value Added Tax and there was no credit receipt provided\"/>\n"
				+ "		<element value=\"IDRC18\" sequence=\"21\" label=\"Merchant properly disclosed a limited return or cancellation policy at the time of the transaction\"/>\n"
				+ "		<element value=\"IDRC19\" sequence=\"22\" label=\"Cardholder received merchant cancellation or return policy and did not cancel according to policy\"/>\n"
				+ "		<element value=\"IDRC20\" sequence=\"23\" label=\"A copy of ATM Transaction Record to prove distributed cash amount or Load Transaction value\"/>\n"
				+ "		<element value=\"IDRC21\" sequence=\"24\" label=\"Docs to support merchant claim that merchandise is not counterfeit\"/>\n"
				+ "		<element value=\"IDRC22\" sequence=\"25\" label=\"Docs to prove terms of sale were not misrepresented\"/>\n"
				+ "		<element value=\"IDRC23\" sequence=\"26\" label=\"Dispute is for quality\"/>\n"
				+ "		<element value=\"IDRC24\" sequence=\"27\" label=\"Cardholder did not attempt to return merchandise\"/>\n"
				+ "		<element value=\"IDRC25\" sequence=\"28\" label=\"Not listed above\"/>\n"
				+ "		<element value=\"IDRC26\" sequence=\"29\" label=\"The cardholder used services after cancellation date and prior to dispute processing date\"/>\n"
				+ "	</element>\n"
				+ "	<element label=\"Provide brief invalid dispute reason that was not listed\" max_length=\"10000\" name=\"not_listed_dispute_invalid_reason\" type=\"string\"/>\n"
				+ "	<element label=\"Provide ARN and Date of the Credit/Reversal\" max_length=\"10000\" name=\"arn_and_date_credit_reversal\" type=\"string\"/>\n"
				+ "	<element label=\"What is the correct transaction date?\" max_length=\"8\" name=\"correct_transaction_date\" type=\"glide_date\"/>\n"
				+ "	<element label=\"Authorization obtained date\" max_length=\"8\" name=\"authorization_date\" type=\"glide_date\"/>\n"
				+ "	<element label=\"Why are you initiating Pre-Arbitration?\" max_length=\"2\" name=\"initiate_pre_arb_reason\" type=\"choice\" choice=\"1\">\n"
				+ "		<choice>\n"
				+ "			<element value=\"ND\" sequence=\"0\" label=\"Cardholder No Longer Disputes\"/>\n"
				+ "			<element value=\"CP\" sequence=\"0\" label=\"Credit or Reversal Processed\"/>\n"
				+ "			<element value=\"ID\" sequence=\"0\" label=\"Invalid Dispute\"/>\n"
				+ "			<element value=\"CE\" sequence=\"0\" label=\"Compelling Evidence\"/>\n"
				+ "			<element value=\"MI\" sequence=\"0\" label=\"Evidence of Imprint\"/>\n"
				+ "			<element value=\"RE\" sequence=\"0\" label=\"Remedy - Prior Undisputed Non-Fraud Transactions\"/>\n"
				+ "			<element value=\"DC\" sequence=\"0\" label=\"Delayed charge transaction\"/>\n"
				+ "     </choice>\n"
				+ "	</element>\n"
				+ "	<element label=\"Are you changing the dispute amount?\" max_length=\"1\" name=\"dispute_amount_change_ind\" type=\"choice\" choice=\"1\">\n"
				+ "		<choice>\n"
				+ "			<element label=\"Yes\" sequence=\"0\" value=\"Y\"/>\n"
				+ "			<element label=\"No\" sequence=\"1\" value=\"N\"/>\n"
				+ "		</choice>\n"
				+ "	</element>\n"
				+ "	<element label=\"Reason for Change and or Certification Requirements\" max_length=\"10000\" name=\"change_explanation\" type=\"string\"/>\n"
				+ "	<element label=\"Are you changing your dispute category/Condition?\" max_length=\"1\" name=\"dispute_category_change_ind\" type=\"choice\" choice=\"1\">\n"
				+ "		<choice>\n"
				+ "			<element label=\"Yes\" sequence=\"0\" value=\"Y\"/>\n"
				+ "			<element label=\"No\" sequence=\"1\" value=\"N\"/>\n"
				+ "		</choice>\n"
				+ "	</element>\n"
				+ "	<element label=\"Are you providing new information?\" max_length=\"1\" name=\"providing_new_info_ind\" type=\"choice\" choice=\"1\">\n"
				+ "		<choice>\n"
				+ "			<element label=\"Yes\" sequence=\"0\" value=\"Y\"/>\n"
				+ "			<element label=\"No\" sequence=\"1\" value=\"N\"/>\n"
				+ "		</choice>\n"
				+ "	</element>\n"
				+ "	<element label=\"Summary of New Information\" max_length=\"10000\" name=\"new_info_summary\" type=\"string\"/>\n"
				+ "	<element label=\"What was provided?\" max_length=\"30\" name=\"merchandise_or_services_1\" type=\"choice\" choice=\"1\">\n"
				+ "		<choice>\n"
				+ "			<element label=\"Merchandise\" sequence=\"10\" value=\"Merchandise\"/>\n"
				+ "			<element label=\"Services\" sequence=\"20\" value=\"Services\"/>\n"
				+ "		</choice>\n"
				+ "	</element>\n"
				+ "	<element label=\"Date merchandise delivered/picked up by cardholder or services were provided\" max_length=\"8\" name=\"merchandise_or_services_provided_date\" type=\"glide_date\"/>\n"
				+ "	<element label=\"Description of merchandise or services provided\" max_length=\"5000\" name=\"merchandise_or_services_desc\" type=\"string\"/>\n"
				+ "	<element label=\"Shipping / Delivery status\" max_length=\"3\" name=\"shipping_delivery_status\" type=\"choice\" choice=\"1\">\n"
				+ "		<choice>\n"
				+ "			<element value=\"NS\" sequence=\"10\" label=\"Not Shipped\"/>\n"
				+ "			<element value=\"B\" sequence=\"10\" label=\"Backordered\"/>\n"
				+ "			<element value=\"IT\" sequence=\"10\" label=\"In transit\"/>\n"
				+ "			<element value=\"PS\" sequence=\"10\" label=\"Partial Shipped\"/>\n"
				+ "			<element value=\"S\" sequence=\"10\" label=\"Shipped\"/>\n"
				+ "			<element value=\"C\" sequence=\"10\" label=\"Cancelled\"/>\n"
				+ "			<element value=\"SE\" sequence=\"10\" label=\"Shipping Exception\"/>\n"
				+ "			<element value=\"P\" sequence=\"10\" label=\"Picked Up by customer\"/>\n"
				+ "			<element value=\"O\" sequence=\"10\" label=\"Other\"/>\n"
				+ "			<element value=\"D\" sequence=\"10\" label=\"Delivered\"/>\n"
				+ "		</choice>\n"
				+ "	</element>\n"
				+ "	<!-- <element label=\"Un disputed transaction\" /> -->\n"
				+ "	<element label=\"Explain why are you initiating Pre-Arbitration?\" max_length=\"10000\" name=\"pre_arb_reason\" type=\"string\"/>\n"
				+ "	<element label=\"How will the amount be sent?\" max_length=\"3\" name=\"how_amount_be_sent\" type=\"string\">\n"
				+ "		<choice>\n"	
				+ "			<element value=\"MFD\" label=\"We will credit you through Miscellaneous Funds Disbursement\" sequence=\"10\"/>\n"
				+ "			<element value=\"MFC\" label=\"Debit us through Miscellaneous Fee Collection\" sequence=\"20\"/>\n"
				+ "			<element value=\"OTH\" label=\"Other\" sequence=\"30\"/>\n"
				+ "		</choice>\n"
				+ "	</element>\n"
				+ "	<element label=\"Payment Instructions\" max_length=\"10000\" name=\"payment_instructions\" type=\"string\"/>\n"
				+ "	<element label=\"Issuer certifies that they have contacted their cardholder and reviewed the compelling evidence with them and cardholder continues to dispute\" max_length=\"1\" name=\"issuer_certifies_cardholder_comp_evidence\" type=\"choice\" choice=\"1\">\n"
				+ "		<choice>\n"
				+ "			<element label=\"Yes\" sequence=\"0\" value=\"Y\"/>\n"
				+ "			<element label=\"No\" sequence=\"1\" value=\"N\"/>\n"
				+ "		</choice>\n"
				+ "	</element>\n"
				+ "	<element label=\"Explanation of why the cardholder continues to dispute the transaction\" max_length=\"10000\" name=\"cardholder_continues_dispute\" type=\"string\"/>\n"
				+ "	<element label=\"Issuer certifies that the cardholder name and address provided by the acquirer does not match the issuer’s records\" max_length=\"1\" name=\"cardholder_name_address_not_match_ind\" type=\"choice\" choice=\"1\">\n"
				+ "		<choice>\n"
				+ "			<element label=\"Yes\" sequence=\"0\" value=\"Y\"/>\n"
				+ "			<element label=\"No\" sequence=\"1\" value=\"N\"/>\n"
				+ "		</choice>\n"
				+ "	</element>\n"
				+ "	<element label=\"Explanation of why you are continuing the dispute\" max_length=\"10000\" name=\"explain_continuing_dispute\" type=\"string\"/>\n"
				+ "	<element label=\"Reason for Filing \" max_length=\"5000\" name=\"filing_reason\" type=\"string\"/>\n"
				+ "</sn_bom_credit_card_disputes_intake>\n"
				+ "";
		xmlString = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"
				+ "<unload unload_date=\"2021-05-04 19:14:10\">\n"
				+ "<sn_hcls_practitioner_specialty action=\"INSERT_OR_UPDATE\">\n"
				+ "<active>true</active>\n"
				+ "<practitioner display_value=\"Amy Yang\">303a895991bf2010f877554329994a01</practitioner>\n"
				+ "<practitioner_type display_value=\"Diabetologist\">8337cd5591bf2010f877554329994ac0</practitioner_type>\n"
				+ "<specialty display_value=\"Diabetic medicine\">5500419191bf2010f877554329994a25</specialty>\n"
				+ "<sys_created_by>abel.tuter</sys_created_by>\n"
				+ "<sys_created_on>2021-04-27 15:54:51</sys_created_on>\n"
				+ "<sys_id>54aacd5991bf2010f877554329994a80</sys_id>\n"
				+ "<sys_mod_count>0</sys_mod_count>\n"
				+ "<sys_updated_by>abel.tuter</sys_updated_by>\n"
				+ "<sys_updated_on>2021-04-27 15:54:51</sys_updated_on>\n"
				+ "</sn_hcls_practitioner_specialty>\n"
				+ "<sn_hcls_practitioner_specialty action=\"INSERT_OR_UPDATE\">\n"
				+ "<active>true</active>\n"
				+ "<practitioner display_value=\"Amy Yang\">303a895991bf2010f877554329994a01</practitioner>\n"
				+ "<practitioner_type display_value=\"Cardiologist\">6257cd9591bf2010f877554329994ae3</practitioner_type>\n"
				+ "<specialty display_value=\"Cardiology\">9420cd5191bf2010f877554329994a01</specialty>\n"
				+ "<sys_created_by>abel.tuter</sys_created_by>\n"
				+ "<sys_created_on>2021-04-27 15:56:05</sys_created_on>\n"
				+ "<sys_id>89ea819991bf2010f877554329994add</sys_id>\n"
				+ "<sys_mod_count>0</sys_mod_count>\n"
				+ "<sys_updated_by>abel.tuter</sys_updated_by>\n"
				+ "<sys_updated_on>2021-04-27 15:56:05</sys_updated_on>\n"
				+ "</sn_hcls_practitioner_specialty>\n"
				+ "<sn_hcls_practitioner_specialty action=\"INSERT_OR_UPDATE\">\n"
				+ "<active>true</active>\n"
				+ "<practitioner display_value=\"Amy Yang\">303a895991bf2010f877554329994a01</practitioner>\n"
				+ "<practitioner_type display_value=\"Doctor\">4007c99591bf2010f877554329994a13</practitioner_type>\n"
				+ "<specialty display_value=\"General practice\">34ef309191bf2010f877554329994a8d</specialty>\n"
				+ "<sys_created_by>abel.tuter</sys_created_by>\n"
				+ "<sys_created_on>2021-04-27 15:54:38</sys_created_on>\n"
				+ "<sys_id>e19a8d5991bf2010f877554329994aad</sys_id>\n"
				+ "<sys_mod_count>0</sys_mod_count>\n"
				+ "<sys_updated_by>abel.tuter</sys_updated_by>\n"
				+ "<sys_updated_on>2021-04-27 15:54:38</sys_updated_on>\n"
				+ "</sn_hcls_practitioner_specialty>\n"
				+ "<sn_hcls_practitioner_specialty action=\"INSERT_OR_UPDATE\">\n"
				+ "<active>true</active>\n"
				+ "<practitioner display_value=\"Jason Trent\">b6f8c51991bf2010f877554329994a7f</practitioner>\n"
				+ "<practitioner_type display_value=\"Doctor\">4007c99591bf2010f877554329994a13</practitioner_type>\n"
				+ "<specialty display_value=\"General practice\">34ef309191bf2010f877554329994a8d</specialty>\n"
				+ "<sys_created_by>abel.tuter</sys_created_by>\n"
				+ "<sys_created_on>2021-04-27 15:50:58</sys_created_on>\n"
				+ "<sys_id>07b9415991bf2010f877554329994a9b</sys_id>\n"
				+ "<sys_mod_count>0</sys_mod_count>\n"
				+ "<sys_updated_by>abel.tuter</sys_updated_by>\n"
				+ "<sys_updated_on>2021-04-27 15:50:58</sys_updated_on>\n"
				+ "</sn_hcls_practitioner_specialty>\n"
				+ "<sn_hcls_practitioner_specialty action=\"INSERT_OR_UPDATE\">\n"
				+ "<active>true</active>\n"
				+ "<practitioner display_value=\"Jason Trent\">b6f8c51991bf2010f877554329994a7f</practitioner>\n"
				+ "<practitioner_type display_value=\"Internal medicine specialist\">c317099591bf2010f877554329994a6a</practitioner_type>\n"
				+ "<specialty display_value=\"Internal medicine\">68ff7c5191bf2010f877554329994ab2</specialty>\n"
				+ "<sys_created_by>abel.tuter</sys_created_by>\n"
				+ "<sys_created_on>2021-04-27 15:51:11</sys_created_on>\n"
				+ "<sys_id>2ac9cd1991bf2010f877554329994ab0</sys_id>\n"
				+ "<sys_mod_count>0</sys_mod_count>\n"
				+ "<sys_updated_by>abel.tuter</sys_updated_by>\n"
				+ "<sys_updated_on>2021-04-27 15:51:11</sys_updated_on>\n"
				+ "</sn_hcls_practitioner_specialty>\n"
				+ "</unload>";
		System.out.println(generateLabelFieldRecords(xmlString));
		//		System.out.println(columnSet);
		//		System.out.println(columnSet.size());


	}

	private static String generateLabelFieldRecords(String xmlElements) {
		StringBuffer result = new StringBuffer();

		try {

			//Creating a DocumentBuilder Object
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance(); 
			DocumentBuilder docBuilder = factory.newDocumentBuilder();

			//Reading the XML
			StringBuilder xmlBuilder = new StringBuilder(); 
			xmlBuilder.append(xmlElements);

			//Parsing the XML Document
			ByteArrayInputStream input = new ByteArrayInputStream(xmlBuilder.toString().getBytes("UTF-8"));
			Document xmldoc = docBuilder.parse(input);
			String templateString = "gr.initialize();\n\n"
					+ "gr.setValue('table_name','sn_bom_credit_card_cardholder_dispute_intake');\n"
					+ "gr.setValue('column_name',\'%s\');\n"
					+ "gr.setValue('question_label',\'%s\');\n"
					+ "\n"
					+ "gr.insert();\n\n";
			//Retrieving the Root Element
//			NodeList nList = xmldoc.getElementsByTagName("element");
			NodeList nList = xmldoc.getElementsByTagName("sys_id");
			String sysIds="";
			for (int temp = 0; temp < nList.getLength(); temp++) {      
				Node nNode = nList.item(temp);
				
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					
					Element eElement = (Element) nNode;
					NodeList cnList = nNode.getChildNodes();
					
					for(int t = 0;t < cnList.getLength(); t++) {
						Node cnNode = cnList.item(t);
						sysIds = sysIds+","+cnNode.getNodeValue();
					}
//					System.out.println(nNode.getChildNodes()[0]);
//					System.out.println(eElement.getNodeValue());
//					if(eElement.getParentNode().getNodeName() == "sn_bom_credit_card_disputes_intake") {
//						String insertString = String.format(templateString, eElement.getAttribute("name").trim(),eElement.getAttribute("label").trim());
//						result.append(insertString);
//					}
				}
			}
			System.out.println(sysIds);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		

		return result.toString();
	}
	private static String getXMLElement(Dict d) {
		String baseString = "<element label=\"%s\" max_length=\"%s\" name=\"%s\" type=\"%s\"/>";
		String choiceYNString = "<element label=\"%s\" max_length=\"1\" name=\"%s\" type=\"choice\" choice=\"1\">\n"
				+ "	<choice>\n"
				+ "		<element label=\"Yes\" sequence=\"0\" value=\"Y\"/>\n"
				+ "		<element label=\"No\" sequence=\"1\" value=\"N\"/>\n"
				+ "	</choice>\n"
				+ "</element>";
		String finalString = null;
		int max_length = 250;

		if(d.dataType.contains("String")) {


			if(d.dataType.contains("(")) {
				max_length = Integer.parseInt(d.dataType.substring(d.dataType.indexOf('(')+1,d.dataType.indexOf(')')));
				System.out.println(max_length);
			}

			finalString = String.format(baseString, d.label,max_length,d.internalName,"string");

		}else if(d.dataType.equalsIgnoreCase("date")) {
			finalString = String.format(baseString, d.label,8,d.internalName,"glide_date");
		}else if(d.dataType.equalsIgnoreCase("boolean") || d.dataType.equalsIgnoreCase("YNType")) {
			finalString = String.format(choiceYNString, d.label,d.internalName);
		}else if(d.dataType.equalsIgnoreCase("AmountType")) {
			finalString = String.format(baseString, d.label,20,d.internalName,"currency");
		}else {
			finalString = String.format(baseString, d.label,max_length,d.internalName,"string");
		}

		return finalString;

	}

}

class Dict {
	String label;
	String internalName;
	String dataType;

	Dict(String label, String internalName, String dataType) {
		this.dataType = dataType;
		this.label = label;
		this.internalName = internalName;
	}
}
