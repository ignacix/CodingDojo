package com.cd.lookify.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cd.lookify.models.SongModel;
import com.cd.lookify.repositories.SongRepo;

@Service
public class SongService {

	@Autowired
	private SongRepo songRepo;
	
	//return all the songs
	public List<SongModel> allSongs(){
		return songRepo.findAll() ;
	}
	
	// create a new song
	public SongModel createSong(SongModel s) {
		return songRepo.save(s);
	}
	
	
	// Get information about a language
	public SongModel findSong(Long id){
		Optional<SongModel> optionalSong = songRepo.findById(id);
		if(optionalSong.isPresent()) {
			return optionalSong.get();
		}else {
			return null;
		}		
	}
	
	//Upload
	public SongModel updateSong(SongModel song) {
		SongModel songSelected = findSong(song.getId());
		songSelected.setArtist(song.getArtist());
		songSelected.setTitle(song.getTitle());
		songSelected.setRating(song.getRating());
		return songRepo.save(songSelected);
	}
	
	//Delete
	public void deleteSong(Long id) {
		songRepo.deleteById(id);;
	}
	
	
	//Get TopTen
	public List<SongModel> getTopTen(){
		return songRepo.getTopTen();
	}
	
	
	//Get SongsByArtist
	public List<SongModel> findByArtist(String artist){
		return songRepo.findByArtist(artist);
	}
	
	
	
	
}
