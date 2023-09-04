package com.saifyahya.songr;

import com.saifyahya.songr.model.Album;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SongrApplicationTests {

	@Test
	void contextLoads() {
	}
@Test
	void testAlbumConstructor() {  //test constructor + getters

	Album album1 = new Album("ABC","Mo",40,120,"any");
	Assertions.assertEquals("ABC",album1.getTitle());
	Assertions.assertEquals("Mo",album1.getArtist());
	Assertions.assertEquals(40,album1.getSongCount());
	Assertions.assertEquals(120,album1.getLengthInSecond());
	Assertions.assertEquals("any",album1.getImageUrl());
}
	@Test
	void testAlbumSetters() {  //test constructor + getters

		Album album1 = new Album("ABC","Mo",40,120,"any");
		album1.setTitle("unknown");
		album1.setArtist("person1");
		album1.setSongCount(50);
		album1.setLengthInSecond(240);
		album1.setImageUrl("image.png");

		Assertions.assertEquals("unknown",album1.getTitle());
		Assertions.assertEquals("person1",album1.getArtist());
		Assertions.assertEquals(50,album1.getSongCount());
		Assertions.assertEquals(240,album1.getLengthInSecond());
		Assertions.assertEquals("image.png",album1.getImageUrl());
	}

}
