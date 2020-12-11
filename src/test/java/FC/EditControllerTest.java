package FC;

import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.*;

public class EditControllerTest {

    @Test
    public void insertCard() throws SQLException {
        //given
        String title = "Testing";
        String term = "term";
        String def = "def";
        EditController editController = new EditController();

        //when
        editController.addDeck(title);
        editController.insertCard(title, term, def);
        Deck deck = editController.getEditDeck();

        //then
        assertEquals(1, deck.getSize());
        editController.deleteDeck(title);

    }

    @Test
    public void deleteCard() throws SQLException {
        //given
        String title = "Testing";
        String term = "term";
        String def = "def";
        EditController editController = new EditController();

        //when
        editController.addDeck(title);
        editController.insertCard(title, term, def);
        Deck deck = editController.getEditDeck();
        Card card = deck.getCard(0);
        editController.deleteCard(card, title);

        //then
        assertEquals(0, deck.getSize());
        editController.deleteDeck(title);

    }

    @Test
    public void initializeNewDeck() throws SQLException {
        //given
        EditController editController = new EditController();
        String title = "Testing";

        //when
        editController.initializeNewDeck(title);

        //then
        assertNotNull(editController.getDeck(title));
        editController.deleteDeck(title);

    }

    @Test
    public void deleteDeck() throws SQLException {
        //given
        EditController editController = new EditController();
        Controller controller = new Controller();
        String title = "Testing";

        //when
        controller.addDeck(title);
        editController.deleteDeck(title);


        //then
        try {
            editController.getDeck(title);
        } catch (SQLException sqlException) {
            sqlException.getErrorCode();
            assertEquals(1, sqlException.getErrorCode());
        }

    }
}