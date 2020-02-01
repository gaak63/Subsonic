/*
  This file is part of Subsonic.
	Subsonic is free software: you can redistribute it and/or modify
	it under the terms of the GNU General Public License as published by
	the Free Software Foundation, either version 3 of the License, or
	(at your option) any later version.
	Subsonic is distributed in the hope that it will be useful,
	but WITHOUT ANY WARRANTY; without even the implied warranty of
	MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
	GNU General Public License for more details.
	You should have received a copy of the GNU General Public License
	along with Subsonic. If not, see <http://www.gnu.org/licenses/>.
	Copyright 2015 (C) Scott Jackson
*/

package com.github.gaak63.gsub.fragments;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.github.gaak63.gsub.R;
import com.github.gaak63.gsub.adapter.SectionAdapter;
import com.github.gaak63.gsub.domain.Genre;
import com.github.gaak63.gsub.service.MusicService;
import com.github.gaak63.gsub.util.Constants;
import com.github.gaak63.gsub.util.ProgressListener;
import com.github.gaak63.gsub.adapter.GenreAdapter;
import com.github.gaak63.gsub.view.UpdateView;

import java.util.List;

public class SelectGenreFragment extends SelectRecyclerFragment<Genre> {
	private static final String TAG = SelectGenreFragment.class.getSimpleName();

	@Override
	public int getOptionsMenu() {
		return R.menu.empty;
	}

	@Override
	public SectionAdapter getAdapter(List<Genre> objs) {
		return new GenreAdapter(context, objs, this);
	}

	@Override
	public List<Genre> getObjects(MusicService musicService, boolean refresh, ProgressListener listener) throws Exception {
		return musicService.getGenres(refresh, context, listener);
	}

	@Override
	public int getTitleResource() {
		return R.string.main_albums_genres;
	}
	
	@Override
	public void onItemClicked(UpdateView<Genre> updateView, Genre genre) {
		SubsonicFragment fragment = new SelectDirectoryFragment();
		Bundle args = new Bundle();
		args.putString(Constants.INTENT_EXTRA_NAME_ALBUM_LIST_TYPE, "genres");
		args.putInt(Constants.INTENT_EXTRA_NAME_ALBUM_LIST_SIZE, 20);
		args.putInt(Constants.INTENT_EXTRA_NAME_ALBUM_LIST_OFFSET, 0);
		args.putString(Constants.INTENT_EXTRA_NAME_ALBUM_LIST_EXTRA, genre.getName());
		fragment.setArguments(args);

		replaceFragment(fragment);
	}

	@Override
	public void onCreateContextMenu(Menu menu, MenuInflater menuInflater, UpdateView<Genre> updateView, Genre item) {}

	@Override
	public boolean onContextItemSelected(MenuItem menuItem, UpdateView<Genre> updateView, Genre item) {
		return false;
	}
}
