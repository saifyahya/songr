# songr
Spring application contains of these things:

- **Controllers**
1. *WelcomeController :*
It contains 3 Routes:
- *"/"* : represents the home page, and it renders a home template.  
- *"/hello"* : it is a body response with *name* `@RequestParam`, it returns hello plus the name provided.
- *"/capitalize/{sentence}"* : sentence is `@PathVariable` that the user provides it with the path, it returns capitalize template with the sentence provided capitalized.

2. *AlbumController :*
It contains one route:
- *"/albums"* : it is a body response, returns an array with three instances of Album class.
---
- **Templates**
1. *capitalize*: associated with *"/capitalize/{sentence}"* route.
2. *home*: associated with *"/"* route.
---
- **Static**
1. *style.css*: associated to *home* template.