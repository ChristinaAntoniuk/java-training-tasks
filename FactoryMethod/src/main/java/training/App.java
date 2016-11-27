package training;

import java.util.Date;

public class App 
{
    public static void main( String[] args )
    {

        WatchMaker watchMaker = getMakerByName("Rome");
        Watch watch = watchMaker.createWatch();
        watch.ShowTime();
    }

    public static WatchMaker getMakerByName(String name){
        if (name.equals("Digital")){
            return new DigitalWatchMaker();
        }
        else{
            if(name.equals("Rome")){
                return new RomeWatchMaker();
            }
            throw new RuntimeException("Non-existent watch");
        }
    }
}

interface Watch{
        void ShowTime();
}

class DigitalWatch implements Watch{

    public void ShowTime() {
        System.out.println(new Date());
    }
}

class RomeWatch implements Watch{

    @Override
    public void ShowTime() {
        System.out.println("VII-XX");
    }
}

interface WatchMaker{
    Watch createWatch();
}

class RomeWatchMaker implements WatchMaker{

    @Override
    public Watch createWatch() {
        return new RomeWatch();
    }
}

class DigitalWatchMaker implements WatchMaker{

    @Override
    public Watch createWatch() {
        return new DigitalWatch();
    }
}