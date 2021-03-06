/*
 * JBoss, Home of Professional Open Source.
 * Copyright 2012, Red Hat, Inc., and individual contributors
 * as indicated by the @author tags. See the copyright.txt file in the
 * distribution for a full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */

package org.jboss.narayana.txframework.api.management;

import org.jboss.narayana.txframework.api.exception.TXControlRuntimeException;

/**
 * Interface defining at the most generic level a transaction control object which can be injected into a
 * framework web service or lifecycle method. Instances of this type and its subtypes can be uses
 * to type fields which are the target of a TxManagement attribute. A TxControl provides a set of
 * operations which the web service or lifecycle method can use to influence the logic of the
 * transaction.
 */
public interface TxControl {

    /**
     * this method can be called from a web service method while a transaction is active to notify the
     * framework that no changes have been made during execution of the service method.
     */
    public void readOnly() throws TXControlRuntimeException;

    /**
     * this method can be called from a web service or lifecycle method to notify the framework that the
     * transaction has failed and may have left the service in an inconsistent state
     */
    public void fail() throws TXControlRuntimeException;
}
