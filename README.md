# songr
Spring application contains of these things:

- **Controllers**
1. *WelcomeController :*
It contains 3 Routes:
- *"/"* : represents the home page, and it renders a home template.  
- *"/hello"* : it is a body response with *name* `@RequestParam`, it returns hello plus the name provided.
- *"/capitalize/{sentence}"* : sentence is `@PathVariable` that the user provides it with the path, it returns capitalize template with the sentence provided capitalized.

2. *AlbumController :*
It contains routes:
- *"/albums"* : it is triggered by **REST** request `GET`, it finds all the albums in DB using the repo and render them in *albums.html*.
- *"/create-album"*: it is triggered by **REST** request `POST` by a create form in *albums* page, it allows the user to create a new album and save it to DB using the **repo**.
- *"/delete-album"*: it is triggered by **REST** request `Delete` by a button in *albums* page, it allows the user to delete album from DB by `@PathVariable` *id* and using delete by id from the **repo**.
- *"/update-album"*:it is triggered by **REST** request `GET`, it renders a new page *update-album* that contains a form to update album info.
- *"/update-album"*:it is triggered by **REST** request `POST`, it will update the album info in the database.
- *"/album"*: it is triggered by a search by title form in *albums* page, it finds album by title using the **repo** and returns a new page *album* containing album info.
---
- **Templates**
1. *capitalize*: associated with *"/capitalize/{sentence}"* route.
2. *home*: associated with *"/"* route.
3. *albums*: associated with *"/albums"* route.
4. *album*: associated with *"/album"* route.
5. *update-album*: associated with *"/update-album"* route.
---
- **Static**
1. *style.css*: associated to *home* template.