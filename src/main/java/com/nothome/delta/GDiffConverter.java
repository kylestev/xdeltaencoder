/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nothome.delta;

import com.nothome.delta.DiffWriter;
import com.nothome.delta.GDiffPatcher;
import com.nothome.delta.SeekableSource;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * <p>GDiffConverter class.</p>
 *
 * @author fm
 * @version $Id: $Id
 */
public class GDiffConverter extends GDiffPatcher {
    
    private final DiffWriter writer;
            
    /**
     * <p>Constructor for GDiffConverter.</p>
     *
     * @param writer a {@link com.nothome.delta.DiffWriter} object.
     */
    public GDiffConverter (DiffWriter writer) {
        this.writer = writer;
    }

    @Override
    void append(int length, InputStream patch, OutputStream output) throws IOException {
        for (int i=0; i<length; i++) {
            writer.addData((byte)patch.read());
        }
    }

    @Override
    void copy(long offset, int length, SeekableSource source, OutputStream output) throws IOException {
        writer.addCopy(offset, length);
    }

    @Override
    void flush(OutputStream os) throws IOException {
        writer.flush();
        writer.close();
    }
    
    
}
