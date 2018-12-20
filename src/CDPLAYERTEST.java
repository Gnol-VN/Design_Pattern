class Cdplayer implements IPushedCallBack{
    @Override
    public void notifyPushedButton(Button b) {
        if(b instanceof PlayButton) this.playButtonPushed();
        if(b instanceof StopButton) this.stopButtonPushed();
    }

    private void stopButtonPushed() {
        System.out.println("Stop button pushed");
    }

    private void playButtonPushed() {
        System.out.println("Play button pushed");
    }
}
class StopButton implements Button{
    IPushedCallBack iPushedCallBack;

    public StopButton(IPushedCallBack iPushedCallBack) {
        this.iPushedCallBack = iPushedCallBack;
    }
    @Override
    public void push() {
        iPushedCallBack.notifyPushedButton(this);
    }
}

interface IPushedCallBack{
    void notifyPushedButton(Button b);
}
interface Button{
    void push();
}
class PlayButton implements Button{
    IPushedCallBack iPushedCallBack;

    public PlayButton(IPushedCallBack iPushedCallBack) {
        this.iPushedCallBack = iPushedCallBack;
    }

    @Override
    public void push() {
        iPushedCallBack.notifyPushedButton(this);
    }
}

public class CDPLAYERTEST{
    public static void main(String[] args) {
        IPushedCallBack cdplayer = new Cdplayer();
        Button playButton =  new PlayButton(cdplayer);
        playButton.push();
        Button stopButton = new StopButton(cdplayer);
        stopButton.push();
    }
}