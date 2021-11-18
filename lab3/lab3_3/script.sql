CREATE TABLE quotes (
    quoteId INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    quote VARCHAR(255),
    movieId INT,
    FOREIGN KEY (movieId) REFERENCES movie(id)
)

INSERT INTO movie VALUES(1,"Captain America: The First Avenger",2011)
INSERT INTO movie VALUES(2,"Doctor Strange",2016)

INSERT INTO quotes VALUES(1,"I Could Do This All Day",1)
INSERT INTO quotes VALUES(2,"Hail Hydra!",1)
INSERT INTO quotes VALUES(3,"It's not about you.",2)
INSERT INTO quotes VALUES(4,"The Wi-Fi Password",2)