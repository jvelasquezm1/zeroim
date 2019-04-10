package reactive.mapper;

public interface ObjectMapper {
    <T> T map(Object src, Class<T> target);
    <T> T mapBuilder(Object src, Class<T> target);
}
