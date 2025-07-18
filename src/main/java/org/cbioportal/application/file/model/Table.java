package org.cbioportal.application.file.model;

import static java.util.Collections.emptyList;

import com.google.common.collect.Iterators;
import com.google.common.collect.PeekingIterator;
import java.io.Closeable;
import java.io.IOException;
import java.util.SequencedMap;
import java.util.SequencedSet;
import org.cbioportal.application.file.utils.CloseableIterator;

/**
 * A class representing a table of data.
 *
 * <p>This class implements the {@link CloseableIterator} interface to allow iteration over the rows
 * of the table. It also implements the {@link HeaderInfo} interface to provide information about
 * the table's header and comments.
 */
public class Table implements CloseableIterator<SequencedMap<String, String>>, HeaderInfo {

  private final PeekingIterator<? extends TableRow> rows;
  private final Closeable closeable;
  private SequencedSet<String> header;

  public Table(CloseableIterator<? extends TableRow> rows) {
    this.closeable = rows;
    this.rows = Iterators.peekingIterator(rows);
  }

  public Table(CloseableIterator<? extends TableRow> rows, SequencedSet<String> header) {
    this(rows);
    if (this.rows.hasNext() && this.rows.peek().toRow().size() != header.size()) {
      throw new IllegalArgumentException("Header size does not match row size");
    }
    this.header = header;
  }

  @Override
  public boolean hasNext() {
    return rows.hasNext();
  }

  @Override
  public SequencedMap<String, String> next() {
    return rows.next().toRow();
  }

  @Override
  public Iterable<Iterable<String>> getComments() {
    return emptyList();
  }

  @Override
  public SequencedSet<String> getHeader() {
    return header;
  }

  @Override
  public void close() throws IOException {
    closeable.close();
  }
}
