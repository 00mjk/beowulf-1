/*
 * GNU LESSER GENERAL PUBLIC LICENSE Copyright (C) 2006 The Lobo Project
 * 
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 * 
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 * 
 * You should have received a copy of the GNU Lesser General Public License
 * along with this library; if not, write to the Free Software Foundation, Inc.,
 * 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA
 * 
 * Contact info: xamjadmin@users.sourceforge.net
 */

package com.nvarghese.beowulf.common.cobra.html.test;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.nvarghese.beowulf.common.cobra.html.HtmlParserContext;
import com.nvarghese.beowulf.common.cobra.html.UserAgentContext;

/**
 * The <code>SimpleHtmlParserContext</code> is a simple implementation of the
 * {@link com.nvarghese.beowulf.common.cobra.html.HtmlParserContext} interface.
 * Methods in this class should be overridden to provide functionality such as
 * cookies.
 * 
 * @author J. H. S.
 */
public class SimpleHtmlParserContext implements HtmlParserContext {

	private static final Logger logger = Logger.getLogger(SimpleHtmlParserContext.class.getName());

	private UserAgentContext bcontext = null;

	public SimpleHtmlParserContext() {

		super();
	}

	public void error(String message) {

		if (logger.isLoggable(Level.SEVERE)) {
			logger.log(Level.SEVERE, message);
		}
	}

	public void error(String message, Throwable throwable) {

		if (logger.isLoggable(Level.SEVERE)) {
			logger.log(Level.SEVERE, message, throwable);
		}
	}

	public String getCookie() {

		return "";
	}

	public UserAgentContext getUserAgentContext() {

		this.warn("getUserAgentContext(): Not overridden; returning simple one.");
		synchronized (this) {
			if (bcontext == null) {
				bcontext = new SimpleUserAgentContext();
			}
			return bcontext;
		}
	}

	public void setCookie(String cookie) {

		this.warn("setCookie(): Not overridden");
	}

	public void warn(String message) {

		if (logger.isLoggable(Level.WARNING)) {
			logger.log(Level.WARNING, message);
		}
	}

	public void warn(String message, Throwable throwable) {

		if (logger.isLoggable(Level.WARNING)) {
			logger.log(Level.WARNING, message, throwable);
		}
	}
}
