package com.bustanilarifin.akkastreams;

import akka.Done;
import akka.NotUsed;
import akka.actor.ActorSystem;
import akka.japi.function.Procedure;
import akka.stream.ActorMaterializer;
import akka.stream.Materializer;
import akka.stream.javadsl.Source;

import java.util.concurrent.CompletionStage;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        final ActorSystem system = ActorSystem.create("QuickStart");
        final Materializer materializer = ActorMaterializer.create(system);

        Source<Integer, NotUsed> numbers = Source.range(1, 100);
        CompletionStage<Done> done = numbers.runForeach(System.out::println, materializer);
        done.thenRun(system::terminate);
    }
}
