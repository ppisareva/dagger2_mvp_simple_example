package hinapolina.com.dagger2mvp.Utils;

import java.util.ArrayList;
import java.util.List;

import hinapolina.com.dagger2mvp.Data.Item;

public class Utils {
    public static final List<Item> getList(){
        List<Item> list = new ArrayList<>();
        Item item = new Item();
        item.setTitle("Jurassic World: Fallen Kingdom");
        item.setId((long)351286);
        item.setOverview("A volcanic eruption threatens the remaining dinosaurs on the island of Isla Nublar, where the creatures have freely roamed for several years after the demise of an animal theme park known as Jurassic World. Claire Dearing, the former park manager, has now founded the Dinosaur Protection Group, an organization dedicated to protecting the dinosaurs. To help with her cause, Claire has recruited Owen Grady, a former dinosaur trainer who worked at the park, to prevent the extinction of the dinosaurs once again.");
        item.setImage("/to0spRl1CMDvyUbOnbb4fTk3VAd.jpg");
        list.add(item);

        Item item1 = new Item();
        item1.setTitle("Avengers: Infinity War");
        item1.setId((long)351289);
        item1.setOverview("As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality. Everything the Avengers have fought for has led up to this moment - the fate of Earth and existence itself has never been more uncertain.");
        item1.setImage("/7WsyChQLEftFiDOVTGkv3hFpyyt.jpg");
        list.add(item1);

        Item item2 = new Item();
        item2.setTitle("Solo: A Star Wars Story");
        item2.setId((long)351287);
        item2.setOverview("Through a series of daring escapades deep within a dark and dangerous criminal underworld, Han Solo meets his mighty future copilot Chewbacca and encounters the notorious gambler Lando Calrissian.");
        item2.setImage("/4oD6VEccFkorEBTEDXtpLAaz0Rl.jpg");
        list.add(item2);

        Item item3 = new Item();
        item3.setTitle("Red Sparrow");
        item3.setId((long)351285);
        item3.setOverview("Prima ballerina, Dominika Egorova faces a bleak and uncertain future after she suffers an injury that ends her career. She soon turns to Sparrow School, a secret intelligence service that trains exceptional young people to use their minds and bodies as weapons. Dominika emerges as the most dangerous Sparrow after completing the sadistic training process. As she comes to terms with her new abilities, she meets a CIA agent who tries to convince her that he is the only person she can trust.");
        item3.setImage("/vLCogyfQGxVLDC1gqUdNAIkc29L.jpg");
        list.add(item3);

        Item item4 = new Item();
        item4.setTitle("Ocean's 8");
        item4.setId((long)351284);
        item4.setOverview("Debbie Ocean, a criminal mastermind, gathers a crew of seven other female thieves to pull off the heist of the century at New York's annual Met Gala");
        item4.setImage("/7caaqQjTkovwoZsEOPzgHvkzOWB.jpg");
        list.add(item4);

        System.out.println(list.size()+" size");

        return list;
    }
}
