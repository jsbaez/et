package net.jbaez.et.common.utils;

import java.util.Objects;
import java.util.function.Function;
import java.util.function.Predicate;

public class Predicates 
{

	public static <T, V> Predicate<T> equals(V value, Function<T, V> funct)
	{
		return t -> Objects.equals(value, funct.apply(t));
	}
	
	public static <T, V> Predicate<T> equals(Function<T, V> funct1, Function<T, V> funct2)
	{
		return t -> Objects.equals(funct1.apply(t), funct2.apply(t));
	}
	
}
