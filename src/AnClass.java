import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

public @interface AnClass {
	String author() default "Team 129";
	String describtion() default "";
}
