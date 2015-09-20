package ohtu;

import ohtu.verkkokauppa.Kauppa;
import ohtu.verkkokauppa.Kirjanpito;/*
import ohtu.verkkokauppa.Pankki;
import ohtu.verkkokauppa.Varasto;
import ohtu.verkkokauppa.Viitegeneraattori;*/
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        /*
        Kirjanpito k = new Kirjanpito();
        Varasto v = new Varasto(k);
        Pankki p = new Pankki(k);
        Viitegeneraattori g = new Viitegeneraattori();
        Kauppa kauppa = new Kauppa(v, p, g);
                */
        //Kauppa kauppa = new Kauppa(Varasto.getInstance(), Pankki.getInstance(), Viitegeneraattori.getInstance());
                
        ApplicationContext ctx = new FileSystemXmlApplicationContext("src/main/resources/spring-context.xml");

        Kauppa kauppa = ctx.getBean(Kauppa.class);

        // kauppa hoitaa yhden asiakkaan kerrallaan seuraavaan tapaan:
        kauppa.aloitaAsiointi();
        kauppa.lisaaKoriin(1);
        kauppa.lisaaKoriin(3);
        kauppa.lisaaKoriin(3);
        kauppa.poistaKorista(1);
        kauppa.tilimaksu("Pekka Mikkola", "1234-12345");

        // seuraava asiakas
        kauppa.aloitaAsiointi();
        for (int i = 0; i < 24; i++) {
            kauppa.lisaaKoriin(5);
        }

        kauppa.tilimaksu("Arto Vihavainen", "3425-1652");

        // kirjanpito
        Kirjanpito kirjanpito = ctx.getBean(Kirjanpito.class);
        for (String tapahtuma : kirjanpito.getTapahtumat()) {
            System.out.println(tapahtuma);
        }
        
        System.out.println(" - - projekti: verkkokauppa2 - annotaatiot");
		
		//checkstyle testausta
        
        int a = 0;
        int b = 1;
        int c = 2;
        if(a == 0){
        if(b == 1){
        System.out.println(" - - ");if(c==2){}
        }		}
        
        for(i=0;i<2;i++){
            for(j=0;j<2;j++){
                System.out.println(i + " " + j);
                for(k=0;k<2;k++){}
            }
        }
		
		for(i=0;i<2;i++){
            for(j=0;j<2;j++){
                System.out.println(i + " " + j);
                for(k=0;k<2;k++){}
            }
        }
		
    }
}
