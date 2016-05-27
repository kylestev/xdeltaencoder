/*
 * SeekableSource.java
 *
 * Created on May 17, 2006, 12:33 PM
 * Copyright (c) 2006 Heiko Klein
 *
 * Permission is hereby granted, free of charge, to any person obtaining a
 * copy of this software and associated documentation files (the "Software"),
 * to deal in the Software without restriction, including without limitation
 * the rights to use, copy, modify, merge, publish, distribute, sublicense,
 * and/or sell copies of the Software, and to permit persons to whom the
 * Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in 
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL
 * THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS
 * IN THE SOFTWARE.
 *
 */

package com.nothome.delta;

import java.io.Closeable;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;

/**
 * For sources of random-access data, such as {@link java.io.RandomAccessFile}.
 *
 * @author kylestev
 * @version $Id: $Id
 */
public interface SeekableSource extends Closeable {
    
    /**
     * Sets the position for the next {@link #read(ByteBuffer)}.
     *
     * @param pos a long.
     * @throws java.io.IOException if any.
     */
    void seek(long pos) throws IOException ;
    
    /**
     * Reads up to {@link java.nio.ByteBuffer#remaining()} bytes from the source,
     * returning the number of bytes read, or -1 if no bytes were read
     * and EOF was reached.
     *
     * @param bb a {@link java.nio.ByteBuffer} object.
     * @return a int.
     * @throws java.io.IOException if any.
     */
    int read(ByteBuffer bb) throws IOException;
    
}
