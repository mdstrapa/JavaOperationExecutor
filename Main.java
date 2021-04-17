import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    enum MessageType{
        PROCESS_OPERATION,
        WRONG_OPERATION,
        EXIT_PROGRAM
    }

    public static void main(String[] args) {

        Scanner userInput = new Scanner(System.in);
        int selectedOperationNumber = 0;
        int selectedExecutorNumber = 0;
        Operation selectedOperation;
        Executor selectedExecutor;
        boolean keepSelection = true;
        boolean operationResult;

        
        List<Operation> operationList = createOperationList();
        List<Executor> executorList = createExecutorList();
        List<Execution> executionLog = new ArrayList<Execution>();

        showGreetings();
        
        while (keepSelection){
            
            buildOperationMenu(operationList);
            
            selectedOperationNumber = userInput.nextInt();

            if (selectedOperationNumber == 0) keepSelection = false;

            else if ((selectedOperationNumber > 0) && ((selectedOperationNumber - 1) <  operationList.size())) {
                
                selectedOperation = operationList.get(selectedOperationNumber - 1);
           
                showAvailableExecutors(executorList);
                
                selectedExecutorNumber = userInput.nextInt();

                selectedExecutor = executorList.get(selectedExecutorNumber - 1);

                selectedOperation.showDetails();

                operationResult = selectedExecutor.executeOperation(selectedOperation, executionLog);

                executionLog.get(executionLog.size() - 1).showDetails();



            }
            else showMessage(MessageType.WRONG_OPERATION);
        }
        

        showMessage(MessageType.EXIT_PROGRAM);

        userInput.close();
    }

    private static void showMessage(MessageType msgType) {
        System.out.println("");

        switch (msgType){
            case PROCESS_OPERATION: 
                System.out.println("The system will proccess your command. Have a rest and relax.");
                break;
            case WRONG_OPERATION:
                System.out.println("The operation you choose doesn't exist");
                break;
            case EXIT_PROGRAM:
                System.out.println("Have a nice day! Good-bye!");
                break;
        }

        System.out.println("");
    }

    private static void showGreetings() {
        System.out.println("=====================");
        System.out.println("Java Operation Reader");
        System.out.println("=====================");
        System.out.println("");
    }

    private static void buildOperationMenu(List<Operation> operationList) {
        System.out.println("-------------------------------------");
        System.out.println("Select the operation by typing its #:");
        System.out.println("");
        for (Operation operation : operationList) {
            System.out.println(operation.number + " - " + operation.name);
        }
        System.out.println("OR");
        System.out.println("0 - Exit the program");
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

    private static List<Executor> createExecutorList(){
        Executor executor1 = new Executor(1, "Runs on USA");
        Executor executor2 = new Executor(2, "Runs on Brazil");

        List<Executor> executorList = new ArrayList<Executor>();
        executorList.add(executor1);
        executorList.add(executor2);
        return executorList;
    }


    private static void showAvailableExecutors(List<Executor> executorList){
        System.out.println("--------------------------------------------");
        System.out.println("Choose the desired executor by typing its #:");
        System.out.println("");
        for (Executor executor : executorList) {
            System.out.println(executor.id + " - " + executor.description);
        }
        System.out.println("");
        System.out.print("Executor #:");

    }
}