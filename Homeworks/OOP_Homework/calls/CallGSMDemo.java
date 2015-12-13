
public class CallGSMDemo {
	
	public static void main(String[] args) {
		
		GSM sony = new GSM();
		sony.model = "XPeriaZ";
		sony.insertSimCard("0889608513");
		System.out.println(sony.simMobileNumber);
		
		GSM nokia = new GSM();
		nokia.model = "N90";
		nokia.insertSimCard("0885315221");
		System.out.println(nokia.simMobileNumber);
		sony.call(nokia, (short) 232);
		nokia.call(sony, (short) 1452);
		sony.printInfoForTheLastOutgoingCall();
		sony.printInfoForTheLastIncomingCall();
		nokia.printInfoForTheLastOutgoingCall();
		nokia.printInfoForTheLastIncomingCall();
		
		System.out.println(sony.getSumForCall() + " BGN");
		System.out.println(nokia.getSumForCall() + " BGN");

	}
}
