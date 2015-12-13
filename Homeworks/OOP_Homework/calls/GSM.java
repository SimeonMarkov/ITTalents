package calls;

public class GSM {

	String model;
	boolean hasSimCard;
	String simMobileNumber;
	short outgoingCallsDuration;
	Call lastIncomingCall = new Call(); //we initialize this Call object with new Call() otherwise we would receive NullPointerException,because lastOutgoingCall won't point to anything,and when we get lastOUtgoingCall.name,we take the name of something that doesnt point to any object in the heap
	Call lastOutgoingCall = new Call();
	
	//if the number matches the phone number regex,it's a valid number for a SIM card,so we haveSimCard(=true)
	void insertSimCard(String newSimMobileNumber){
		if(newSimMobileNumber.matches("(08)[0-9]{8}")){
			simMobileNumber = newSimMobileNumber;
			hasSimCard = true;
		}
	}
	
	void removeSimCard(){
		hasSimCard = false;
	}
	
	void call(GSM receiver,short currentCallDuration){
		boolean isCallValid = true;
		if(currentCallDuration < 0){ //it could be 0 because we can only call the person without him answer the call(missed call is also possible)
			isCallValid = false;
		}
		if(simMobileNumber.equals(receiver.simMobileNumber)){ //check if the person actually tries to call himself
			isCallValid = false;
		}
		if(!(hasSimCard && receiver.hasSimCard)){ // check if both we and the other person have SIM cards,if at least one of us don't - a call can't be made
			isCallValid = false;
		}
		
		//if eventually all the validation for a call is passed
		if(isCallValid){
			outgoingCallsDuration += currentCallDuration; //summing all outgoing calls minutes
			receiver.lastIncomingCall.caller = this; // we receive an incoming call from who made the call,i.e. from the caller(in this case,"this" -> keyword!!!)
			this.lastOutgoingCall.receiver = receiver; // we are calling to the receiver of an outgoing call
			this.lastOutgoingCall.duration = currentCallDuration; //we save the same duration in both outcoming call for us and incoming call for the other side(phone)
			receiver.lastIncomingCall.duration = currentCallDuration; //for receiver of a call the duration is the same as the duration for the caller in the same call
		}
		
		
	}
	
	void printInfoForTheLastOutgoingCall(){
		System.out.println("Current phone:" + this.model + ";" + this.simMobileNumber);//this is the CALLER in this OUTGOING call
		System.out.print("Last outgoing call is to " + lastOutgoingCall.receiver.simMobileNumber); //the OUTGOING call is TO the RECEIVER
		System.out.println(" and it lasted " + lastOutgoingCall.duration / 3600 + "hours," + lastOutgoingCall.duration / 60 + " minutes and " + lastOutgoingCall.duration % 60 + " seconds");
	}
	void printInfoForTheLastIncomingCall(){
		System.out.println("Current phone:" + this.model + ";" + this.simMobileNumber);//this is the RECEIVER in this INCOMING call
		System.out.print("Last incoming call is from " + lastIncomingCall.caller.simMobileNumber); // the INCOMING call is FROM the CALLER
		System.out.println(" and it lasted " + lastIncomingCall.duration / 3600 + "hours," + lastIncomingCall.duration / 60 + " minutes and " + lastIncomingCall.duration % 60 + " seconds");
	}
	
	
	double getSumForCall(){
		//if we spoke for exactly 4 minutes,we should pay 4*priceForAMinute,BUT if we spoke 4 minutes and 5 seconds,we should pay 5*priceForAMinute
		//in other words, if we spoke x minutes + y seconds,where y > 0 , we pay (x + 1) * priceForAMinute;if y = 0 seconds,we pay x * priceForAMinute
		return ((outgoingCallsDuration % 60 == 0) ?(outgoingCallsDuration/60) :((outgoingCallsDuration/60) + 1)) * Call.priceForAMinute;
	}
	
}
