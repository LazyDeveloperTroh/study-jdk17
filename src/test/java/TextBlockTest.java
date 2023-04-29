import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TextBlockTest {
    String textBlockHtml = """
            <html>

                <body>
                    <span>example text</span>
                </body>
            </html>""";
    @Test
    public void givenAnOldStyleMultilineString_whenComparing_thenEqualsTextBlock() {
        String expected = "<html>\n"
                + "\n"
                + "    <body>\n"
                + "        <span>example text</span>\n"
                + "    </body>\n"
                + "</html>";
        assertEquals(expected, textBlockHtml);
    }


    @Test
    public void givenAnOldStyleString_whenComparing_thenEqualsTextBlock() {
        String expected = "<html>\n\n    <body>\n        <span>example text</span>\n    </body>\n</html>";
        assertEquals(expected, textBlockHtml);
    }

    String textBlockIntent = """
                    Indent
                """;
    @Test
    public void givenAnIndentedString_thenMatchesIndentedOldStyle() {
        String expected = "    Indent\n";
        assertEquals(expected, textBlockIntent);
    }


    String textBlockEscapes = """
                "fun" with
                whitespace
                and other escapes \"""
                """;
    @Test
    public void givenAnEscapesString_thenMatchesEscapesOldStyle() {
        String expected = "\"fun\" with\n"
                +"whitespace\n"
                +"and other escapes \"\"\""
                +"\n";

        assertEquals(expected, textBlockEscapes);
    }

    String textBlockCarriageReturns = """
                separated with\r
                carriage returns""";
    @Test
    void givenATextWithCarriageReturns_thenItContainsBoth(){
        String expected = "separated with\r\ncarriage returns";
        assertEquals(expected, textBlockCarriageReturns);
    }

    String textBlockIgnoredNewLines = """
                This is a long test which looks to \
                have a newline but actually does not""";
    @Test
    void givenAStringWithEscapedNewLines_thenTheResultHasNoNewLines() {
        String expected = "This is a long test which looks to have a newline but actually does not";
        assertEquals(expected, textBlockIgnoredNewLines);
    }


    String textBlockEscapedSpaces = """
                line 1       
                line 2       \s
                """;
    @Test
    void givenAStringWithEscapesSpaces_thenTheResultHasLinesEndingWithSpaces() {
        String expected = "line 1\nline 2        \n";
        assertEquals(expected, textBlockEscapedSpaces);
    }

    String textBlockFormatting = """
                Some parameter: %s
                """.formatted("troh");
    @Test
    void givenAStringWithFormatted_thenResultHasParameter() {
        String expected = "Some parameter: troh\n";
        assertEquals(expected, textBlockFormatting);
    }
}
