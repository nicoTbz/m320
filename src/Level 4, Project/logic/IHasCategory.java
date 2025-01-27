package Project.logic;

/**
 * The {@code IHasCategory} interface provides a method to retrieve the category of an object.
 * Classes implementing this interface should define their own category retrieval logic.
 */
public interface IHasCategory {

    /**
     * Retrieves the category of the implementing object.
     *
     * @return A {@code String} representing the category.
     */
    String getCategory();
}
