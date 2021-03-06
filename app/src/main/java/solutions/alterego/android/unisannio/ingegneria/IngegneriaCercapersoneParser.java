package solutions.alterego.android.unisannio.ingegneria;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;

import javax.inject.Inject;

import solutions.alterego.android.unisannio.cercapersone.Person;
import solutions.alterego.android.unisannio.interfaces.Parser;

public class IngegneriaCercapersoneParser implements Parser<Person> {

    @Inject
    public IngegneriaCercapersoneParser() {
    }

    @Override
    public ArrayList<Person> parse(Document document) {

        ArrayList<Person> persons = new ArrayList<>();

        Elements elements = document.getElementsByTag("item");

        for (Element element:elements){

                String nome = element.getElementsByTag("title").text();
                String ruolo = element.getElementsByTag("position").text();
                String email = element.getElementsByTag("email").text();
                String ufficio = element.getElementsByTag("address").text();
                String telefono = element.getElementsByTag("telephone").text();
                String webPage = element.getElementsByTag("personalwebpage").text();
                String tutoring = element.getElementsByTag("tutoring").text();

            if(nome != null) {
                Person person = new Person(nome, ruolo, email, telefono, ufficio, webPage, tutoring);
                persons.add(person);
            }
        }
                return persons;
    }
}
