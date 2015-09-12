import java.util.ArrayList;
import java.util.List;
import ohtuesimerkki.Player;
import ohtuesimerkki.Reader;
import ohtuesimerkki.Statistics;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class StatisticsTest {
    Statistics stats;
    
    public StatisticsTest() {
        stats = new Statistics(new ReaderStub());
    }

    @Test
    public void searchTest1(){
        Player b = stats.search("Semenko");
        assertEquals("Semenko", b.getName());
    }
    
    @Test
    public void searchTest2(){
        Player b = stats.search("Yzerman");
        assertEquals("DET", b.getTeam());
    }
    
    @Test
    public void searchTest3(){
        Player b = stats.search("Lemieux");
        assertEquals(45, b.getGoals());
    }
    
    @Test
    public void searchTest4(){
        Player b = stats.search("Gretzky");
        assertEquals(89, b.getAssists());
    }
    
    @Test
    public void searchTest5(){
        Player b = stats.search("Väinö");
        assertNull(b);
    }
    
    @Test
    public void teamTest1(){
        List<Player> players = stats.team("EDM");
        assertEquals(3, players.size());
    }
    
    @Test
    public void teamTest2(){
        List<Player> players = stats.team("QWE");
        assertEquals(0, players.size());
    }
    
    @Test
    public void topScoreTest1(){
        /*
        topScorers koodissa
        while (howMany>=0) {...
        */
        List<Player> players = stats.topScorers(3);
        assertEquals(4, players.size());
    }
    
    @Test
    public void topScoreTest2(){
        List<Player> players = stats.topScorers(3);
        assertEquals(89, players.get(0).getAssists());
    }
}

class ReaderStub implements Reader{
    
    public List<Player> getPlayers() {
        ArrayList<Player> players = new ArrayList<Player>();
        players.add(new Player("Semenko", "EDM", 4, 12));
        players.add(new Player("Kurri",   "EDM", 37, 53));
        players.add(new Player("Yzerman", "DET", 42, 56));
        players.add(new Player("Lemieux", "PIT", 45, 54));
        players.add(new Player("Gretzky", "EDM", 35, 89));
        return players;
    }
}
