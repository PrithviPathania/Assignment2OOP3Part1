package implementations;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import exceptions.EmptyQueueException;

// XML PARSER
/*
 * Write an XML parser that will accomplish the following:
 * a. Read supplied XML documents.
 * b. Parse for errors in the XML construction.
 * c. When parsing is complete, print all lines that are not properly constructed
 *    in the order in which the errors occur.
 *
 * Parsing Rules
 *
 * • An opening tag has the format <tag> and a closing tag has the format </tag>.
 *
 * • For every closing tag, there is an earlier, matching opening tag.
 *
 * • Self-closing tags have the format <tag/>.
 *
 * • All tags are case-sensitive.
 *
 * • Every XML document must have one and only one root tag.
 *
 * • Tags in the format <?xml data?> are processing instructions and
 *   should be ignored.
 *
 * • Nested tags cannot intercross.
 *
 * Given Pseudo Code for the XML Parser:
 *
 * If Self_Closing_Tag
 *      Ignore
 * If Start_Tag
 *      Push on stack
 * If End_Tag
 *      If matches top of stack, pop stack and all is well
 *      Else report error
 */

/**
 * XML parser for Assignment 2.
 *
 * Reads an XML file and checks whether tags are opened and closed correctly.
 *
 * @author Gavin
 * @version 1.0
 */
public class MyParser
{
    /**
     * Stores information about a tag.
     */
    private static class TagInfo
    {
        String tagName;
        int lineNumber;

        /**
         * Constructor for a tag object.
         *
         * @param tagName name of the tag
         * @param lineNumber line where the tag was found
         */
        public TagInfo(String tagName, int lineNumber)
        {
            this.tagName = tagName;
            this.lineNumber = lineNumber;
        }
    }

    /**
     * Main method.
     *
     * Example:
     *
     * java MyParser sample.xml
     *
     * @param args command line arguments
     */
    public static void main(String[] args)
    {
        if (args.length != 1)
        {
            System.out.println("Usage: java MyParser <xml file>");
            return;
        }

        String fileName = args[0];

        MyStack<TagInfo> tagStack = new MyStack<>();
        MyQueue<String> errorQ = new MyQueue<>();

        int lineNumber = 0;
        int rootCount = 0;

        try
        {
            BufferedReader reader =
                    new BufferedReader(new FileReader(fileName));

            String line;

            while ((line = reader.readLine()) != null)
            {
                lineNumber++;

                Pattern pattern = Pattern.compile("<[^>]+>");
                Matcher matcher = pattern.matcher(line);

                while (matcher.find())
                {
                    String tag = matcher.group();

                    // Ignore processing instructions
                    if (tag.startsWith("<?") && tag.endsWith("?>"))
                    {
                        continue;
                    }

                    // Ignore self-closing tags
                    if (tag.endsWith("/>"))
                    {
                        continue;
                    }

                    // Closing tag
                    if (tag.startsWith("</"))
                    {
                        String closingTag =
                                tag.substring(2, tag.length() - 1).trim();

                        if (tagStack.isEmpty())
                        {
                            errorQ.enqueue(
                                    "Error at line: "
                                            + lineNumber
                                            + " "
                                            + tag
                                            + " is not constructed correctly");

                            continue;
                        }

                        TagInfo openingTag = tagStack.pop();

                        if (!openingTag.tagName.equals(closingTag))
                        {
                            errorQ.enqueue(
                                    "Error at line: "
                                            + lineNumber
                                            + " "
                                            + tag
                                            + " is not constructed correctly");
                        }
                    }

                    // Opening tag
                    else
                    {
                        String openingTag =
                                tag.substring(1, tag.length() - 1).trim();

                        // Ignore attributes
                        if (openingTag.contains(" "))
                        {
                            openingTag =
                                    openingTag.substring(
                                            0,
                                            openingTag.indexOf(" "));
                        }

                        if (tagStack.isEmpty())
                        {
                            rootCount++;
                        }

                        tagStack.push(
                                new TagInfo(
                                        openingTag,
                                        lineNumber));
                    }
                }
            }

            reader.close();

            // Any tags left open at EOF
            while (!tagStack.isEmpty())
            {
                TagInfo unclosedTag = tagStack.pop();

                errorQ.enqueue(
                        "Error at line: "
                                + unclosedTag.lineNumber
                                + " <"
                                + unclosedTag.tagName
                                + "> is not constructed correctly");
            }

            // Check root count
            if (rootCount != 1)
            {
                errorQ.enqueue(
                        "Error: XML document must contain exactly one root tag.");
            }

            // Print errors in the order they occurred
            if (errorQ.isEmpty())
            {
                System.out.println(
                        "XML Document is constructed correctly.");
            }
            else
            {
                while (!errorQ.isEmpty())
                {
                    System.out.println(errorQ.dequeue());
                }
            }
        }
        catch (IOException e)
        {
            System.out.println(
                    "Error reading file: " + e.getMessage());
        }
        catch (EmptyQueueException e)
        {
            System.out.println(
                    "Queue error: " + e.getMessage());
        }
    }
}