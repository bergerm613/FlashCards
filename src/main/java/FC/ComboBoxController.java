package FC;

import java.sql.SQLException;

public class ComboBoxController extends Controller {
    public ComboBoxController() throws SQLException {
    }
    /**
     * Loads list of decks in the DB for the UI to display upon opening
     */
    public String[] getAllDecks() throws SQLException {
        return super.getAllDecks();
    }
}