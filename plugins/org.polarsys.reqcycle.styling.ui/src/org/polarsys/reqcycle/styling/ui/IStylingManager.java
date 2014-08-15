package org.polarsys.reqcycle.styling.ui;

import org.polarsys.reqcycle.styling.model.Styling.Styling;

public interface IStylingManager {

	/**
	 * Get the Styling
	 */
	public Styling getStyling();

	/**
	 * Set the name of the preferred Styling Model
	 */
	public void setPreferredStylingModel(String stylingModel);

	/**
	 * Get the name of the preferred Styling Model
	 */
	public String getPreferredStyleModel();

	/**
	 * Reload the previous configuration
	 */
	public void reload();

	/**
	 * Save the current configuration
	 */
	public void save();
}
