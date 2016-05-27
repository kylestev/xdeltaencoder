/*
 * #%L
 * XDeltaEncoder
 * %%
 * Copyright (C) 2011 - 2012 Frantisek Mantlik <frantisek at mantlik.cz>
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 2 of the 
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public 
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/gpl-2.0.html>.
 * #L%
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mantlik.xdeltaencoder;

import java.io.IOException;
import java.io.InputStream;

/**
 * <p>LimitInputStream class.</p>
 *
 * @author fm
 * @version $Id: $Id
 */
public class LimitInputStream extends InputStream {

    private InputStream is;
    private long limit = -1;

    LimitInputStream(InputStream is) {
        this.is = is;
    }

    /** {@inheritDoc} */
    @Override
    public int read() throws IOException {
        if (limit < 0) {
            return is.read();
        }
        if (limit > 0) {
            limit--;
            return is.read();
        }
        return -1;
    }

    /** {@inheritDoc} */
    @Override
    public int available() throws IOException {
        if (limit < 0) {
            return super.available();
        }
        return Math.min(super.available(), (int) Math.min(limit, Integer.MAX_VALUE));
    }

    /** {@inheritDoc} */
    @Override
    public long skip(long n) throws IOException {
        if (limit < 0) {
            return super.skip(n);
        }
        long skip = super.skip(Math.min(limit,n));
        limit -= skip;
        return skip;
    }
    
    /**
     * <p>Setter for the field <code>limit</code>.</p>
     *
     * @param limit a long.
     */
    public void setLimit(long limit) {
        this.limit = limit;
    }
}
