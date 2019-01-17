package designPattern.structure;

public class FacadePatternExample {
    public static void main(String[] args) {
        DatabaseFacade databaseFacade = new DatabaseFacade();
        databaseFacade.generateReport("Oracle","localhost","User","PDF");
        databaseFacade.generateReport("MySQL","Amazon RDS","Address","HTML");
    }
}

class DatabaseFacade {
    void generateReport(String DBType, String address, String tableName, String outputFormat){
        DatabaseAction databaseAction;
        if(DBType.equals("MySQL")){
            databaseAction = new MySQLAction();
            databaseAction.openConnection(address);
            if(outputFormat.equals("PDF"))
                databaseAction.generatePDFReport(tableName);
            if(outputFormat.equals("HTML"))
                databaseAction.generateHTMLReport(tableName);
        }
        else if(DBType.equals("Oracle")){
            databaseAction = new OracleAction();
            databaseAction.openConnection(address);
            if(outputFormat.equals("PDF"))
                databaseAction.generatePDFReport(tableName);
            if(outputFormat.equals("HTML"))
                databaseAction.generateHTMLReport(tableName);        }
    }
}

interface DatabaseAction{
    void openConnection(String address);
    void generatePDFReport(String tableName);
    void generateHTMLReport(String tableName);
}

class MySQLAction implements DatabaseAction{

    @Override
    public void openConnection(String address) {
        System.out.println("Connecting to MySQL at: " +address);
    }

    @Override
    public void generatePDFReport(String tableName) {
        System.out.println("Generating MySQL table '"+tableName+"' in PDF format");
    }

    @Override
    public void generateHTMLReport(String tableName) {
        System.out.println("Generating MySQL table '"+tableName+"' in HTML format");
    }
}
class OracleAction implements DatabaseAction{

    @Override
    public void openConnection(String address) {
        System.out.println("Connecting to Oracle at: " +address);
    }

    @Override
    public void generatePDFReport(String tableName) {
        System.out.println("Generating Oracle table '"+tableName+"' in PDF format");
    }

    @Override
    public void generateHTMLReport(String tableName) {
        System.out.println("Generating Oracle table '"+tableName+"' in HTML format");
    }
}