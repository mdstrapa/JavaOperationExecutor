import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner userInput = new Scanner(System.in);

        showGreetings();

        List<Operation> operationList = createOperationList();

        int selectedOperationNumber = 0;
    
        boolean successSelection = false;
        
        while (!successSelection){
            
            buildOperationMenu(operationList);
            
            selectedOperationNumber = userInput.nextInt();

            if ((selectedOperationNumber > 0) && ((selectedOperationNumber - 1) <  operationList.size())) successSelection = true;
            else showFinalMessage(successSelection);
        }
        
        Operation selectedOperation = operationList.get(selectedOperationNumber - 1);

        showSelectedOperation(selectedOperation);

        showFinalMessage(successSelection);

        userInput.close();
    }

    private static void showSelectedOperation(Operation selectedOperation) {
        System.out.println("");
        System.out.println("The selected operation is " + selectedOperation.name);
        System.out.println(selectedOperation.description + " | " + selectedOperation.command);
        System.out.println("");
    }

    private static void showFinalMessage(boolean successSelection) {
        System.out.println("");
        if (successSelection) System.out.println("The system will proccess your command. Have a nice day and relax.");

        else System.out.println("The operation you mentioned doesn't exist");

        System.out.println("");
    }

    private static void showGreetings() {
        System.out.println("=====================");
        System.out.println("Java Operation Reader");
        System.out.println("=====================");
        System.out.println("");
    }

    private static void buildOperationMenu(List<Operation> operationList) {
        System.out.println("Select the operation by typing its #:");
        System.out.println("");
        for (Operation operation : operationList) {
            System.out.println(operation.number + " - " + operation.name);
        }
        System.out.println("");
        System.out.print("Operation #:");
    }

    private static List<Operation> createOperationList() {
        Operation createTicket = new Operation(1,"Create Ticket","This operation creates a ticket in USD","usd -addTicket -I -Default");
        Operation closeTicket = new Operation(2,"Close Ticket","This operation closes a ticket in USD","usd -closeTicket -T %");
        Operation changeTicketStatus = new Operation(3,"Change Ticket Status","This operation changes a ticket status in USD","usd -chgStatus -T %");
        Operation changeTicketDescriptoion = new Operation(4,"Change Ticket Description","This operation changes a ticket description in USD","usd -chgDescription -T %");


        List<Operation> operationList = new ArrayList<Operation>();
        operationList.add(createTicket);
        operationList.add(closeTicket);
        operationList.add(changeTicketStatus);
        operationList.add(changeTicketDescriptoion);
        return operationList;
    }
}