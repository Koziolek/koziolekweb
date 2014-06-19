package pl.koziolekweb;

import com.google.common.base.Stopwatch;

import java.lang.management.ManagementFactory;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 * Hello world!
 */
public class App {
	public static Silnia silnia = new Silnia();

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Witam! Podepnij JConsole. Mój PID to: " + ManagementFactory.getRuntimeMXBean().getName());
		s.nextLine();
		FunctionAlwaysNew aNew = new FunctionAlwaysNew();
		FunctionAsStatic aStatic = new FunctionAsStatic();
		FunctionLambdaInline lInline = new FunctionLambdaInline();
		FunctionLambdaRef lRef = new FunctionLambdaRef();
		FunctionLambdaStatic lStatic = new FunctionLambdaStatic();
		System.out.println("Wprowadź dużą liczbę całkowitą.");
		int max = s.nextInt();
		System.out.println("Tworzę listę z danymi");
		List<BigInteger> ns = new ArrayList<>(max);
		for (int i = 0; i < max; i++)
			ns.add(new BigInteger(i + ""));
		System.out.println("Dane gotowe. Naciśnij enter by zacząć test");
		s.nextLine();

		aStatic(s, aStatic, max, ns);
		aNew(s, aNew, max, ns);
		lInline(s, lInline, max, ns);
		lRef(s, lRef, max, ns);
		lStatic(s, lStatic, max, ns);

	}

	private static void aStatic(Scanner s, FunctionAsStatic aStatic, int max, List<BigInteger> ns) {
		System.out.println("Rozpoczynam test dla przypadku z użyciem pola statycznego.");
		Stopwatch stopwatch = Stopwatch.createUnstarted();
		stopwatch.start();
		for (int i = 0; i < max; i++)
			aStatic.obliczSilnie(ns);
		stopwatch.stop();
		System.out.println("Test zakończony. Zajął " + stopwatch.elapsed(TimeUnit.MILLISECONDS) + "ms");
		s.nextLine();
	}

	private static void lInline(Scanner s, FunctionLambdaInline lInline, int max, List<BigInteger> ns) {
		System.out.println("Rozpoczynam test dla przypadku z użyciem lambdy inline.");
		Stopwatch stopwatch = Stopwatch.createUnstarted();
		stopwatch.start();
		for (int i = 0; i < max; i++)
			lInline.obliczSilnie(ns);
		stopwatch.stop();
		System.out.println("Test zakończony. Zajął " + stopwatch.elapsed(TimeUnit.MILLISECONDS) + "ms");
		s.nextLine();
	}

	private static void lStatic(Scanner s, FunctionLambdaStatic lStatic, int max, List<BigInteger> ns) {
		System.out.println("Rozpoczynam test dla przypadku z użyciem lambdy statycznej.");
		Stopwatch stopwatch = Stopwatch.createUnstarted();
		stopwatch.start();
		for (int i = 0; i < max; i++)
			lStatic.obliczSilnie(ns);
		stopwatch.stop();
		System.out.println("Test zakończony. Zajął " + stopwatch.elapsed(TimeUnit.MILLISECONDS) + "ms");
		s.nextLine();
	}

	private static void lRef(Scanner s, FunctionLambdaRef lRef, int max, List<BigInteger> ns) {
		System.out.println("Rozpoczynam test dla przypadku z użyciem lambdy method ref.");
		Stopwatch stopwatch = Stopwatch.createUnstarted();
		stopwatch.start();
		for (int i = 0; i < max; i++)
			lRef.obliczSilnie(ns);
		stopwatch.stop();
		System.out.println("Test zakończony. Zajął " + stopwatch.elapsed(TimeUnit.MILLISECONDS) + "ms");
		s.nextLine();
	}

	private static void aNew(Scanner s, FunctionAlwaysNew aNew, int max, List<BigInteger> ns) {
		System.out.println("Rozpoczynam test dla przypadku z użyciem new.");
		Stopwatch stopwatch = Stopwatch.createUnstarted();
		stopwatch.start();
		for (int i = 0; i < max; i++)
			aNew.obliczSilnie(ns);
		stopwatch.stop();
		System.out.println("Test zakończony. Zajął " + stopwatch.elapsed(TimeUnit.MILLISECONDS) + "ms");
		s.nextLine();
	}
}

