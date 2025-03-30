package SystemDesign.DesginPatternQuestions.LoggerSystem.LogOutputStrategy;

public class Display {
    PrintInterface logStrategy;
    public void setStrategy(PrintInterface logStrategy) {
        this.logStrategy = logStrategy;
    }
    public void displayMessage(String Message) {
        if(this.logStrategy == null) {
            System.out.println("[+] No where to display, provide medium");
        } else {
            logStrategy.printMessage(Message);
        }
    }
}
