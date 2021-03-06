package learningjava8.streams;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class ToListCollector<T> implements Collector<T, List<T>, List<T>> {

	@Override
	public Supplier<List<T>> supplier() {
		//return () -> new ArrayList<T>();
		return ArrayList::new;
	}

	@Override
	public BiConsumer<List<T>, T> accumulator() {
		//return (a, b) -> a.add(b);
		return List::add;
	}

	@Override
	public BinaryOperator<List<T>> combiner() {
		return (listOne,listTwo)->{
			listOne.addAll(listTwo);
			return listTwo;
		};
	}

	@Override
	public Function<List<T>, List<T>> finisher() {
		return Function.identity();
	}

	@Override
	public Set<Characteristics> characteristics() {
		return Collections.unmodifiableSet(EnumSet.of(Characteristics.IDENTITY_FINISH, Characteristics.CONCURRENT));
	}
	
}
