Create table author(
                        authorID int PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
                        authorName varchar(255)


 );

Create table category(
                         categoryID int PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
                         categoryName varchar(255)


);

Create table book(
                     bookID int PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    --ISBN varchar(255),
                     title varchar(255),
                     publishingDate date,
                     publisher varchar(255)


);

Create table library(
                        libraryID int PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
                        adress varchar(255)

);

Create table bookCopy(
                         bookCopyID int PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
                         bookID int,
                         libraryID int,
                         FOREIGN KEY (libraryID) REFERENCES library(libraryID),
                         FOREIGN KEY (bookID) REFERENCES book(bookID),
                         booktype varchar(255)

);

create table person(
                       personID int PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
                       personName varchar(255),
                       adress varchar(255),
                       phoneNumber varchar(255)

);

Create table loans(
                      loanID int PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
                      personID int,
                      created date,
                      returnDate date,
                      isReturned boolean default false,

                      FOREIGN KEY (personID) REFERENCES person(personID)


);

-- JUNCTION TABLES

Create table membership(
                           personID int,
                           libraryID int,

                           PRIMARY KEY(personID,libraryID),
                           FOREIGN KEY (personID) references person(personID),
                           FOREIGN KEY (libraryID) references library(libraryID)

);

Create table loanedCopies(
                             loanID int,
                             bookCopyID int,

                             PRIMARY KEY(loanID,bookCopyID),
                             FOREIGN KEY (loanID) references loans(loanID),
                             FOREIGN KEY (bookCopyID) references bookcopy(bookCopyID)
);

Create table categoryJunc(
                             bookID int,
                             categoryID int,

                             PRIMARY KEY(bookID,categoryID),
                             FOREIGN KEY (bookID) references book(bookID),
                             FOREIGN KEY (categoryID) references category(categoryID)
);

Create table authorJunc(
                           bookID int,
                           authorID int,

                           PRIMARY KEY(bookID,authorID),
                           FOREIGN KEY (bookID) references book(bookID),
                           FOREIGN KEY (authorID) references author(authorID)
);

Insert into author(authorname)
values
    ('Terry Pratchet'),
    ('Alma Varhaus'),
    ('Selma lagerlöf'),
    ('J.K Rowling'),
    ('Michelle Paver'),
    ('Stephen King'),
    ('George R.R Martin');

Insert into category(categoryName)
values
    ('childs book'),
    ('fantasy'),
    ('novel'),
    ('horror'),
    ('comedy'),
    ('drama');

Insert into person(personname,adress,phonenumber)
values
    ('Adam Spencer','Gräddhyllan 2','073########'),
    ('Moa Larson','Drottninggatan 5','073########'),
    ('Harry Svensson','Snickargatan 3','073########'),
    ('Bo Bertsson','Dillvägen 11','073########'),
    ('Jonathan Söderlund','Gräddhyllan 11','073########'),
    ('Lasse larssson','Dillvägen 12','073########'),
    ('Jan Jansson','Bråkmakargatan 9','073########');

Insert into library(adress)
values
    ('Stödevägen 7'),
    ('Studentvägen 10'),
    ('Matforsgränden 18'),
    ('Timråhuset 34');

Insert into book(title,publisher,publishingdate)
values
    ('Harry Potter: De vises Sten','Bloomsbury Publishing','26 June 1997'),
    ('Harry Potter och Hemligheternas kammare', 'Bloomsbury Publishing', '2 July 1998'),
    ('Harry Potter and the Prisoner of Azkaban', 'Bloomsbury Publishing', '8 July 1999'),
    ('Harry Potter och den flammande bägaren', 'Bloomsbury Publishing', '8 July 2000'),
    ('Harry Potter och Fenixorden', 'Bloomsbury Publishing', '21 June 2003'),
    ('Harry Potter och halvblodsprinsen', 'Bloomsbury Publishing', '16 July 2005'),
    ('Harry Potter och dödsrelikerna', 'Bloomsbury Publishing', '21 July 2007'),
    ('Harry Potter och det fördömda barnet', 'Bloomsbury Publishing', '30 July 2016'),
    ('The Wyrd Sisters','Victor Gollancz Ltd','10 November 1988'),
    ('Hogfather','Victor Gollancz Ltd','01 November 1983'),
    ('Carrie', 'Doubleday', '5 April 1974'),
    ('’Salem’s Lot', 'Doubleday', '17 October 1975'),
    ('The Shining', 'Doubleday', '28 January 1977'),
    ('Night Shift', 'Doubleday', '15 February 1978'),
    ('The Stand', 'Doubleday', '3 October 1978'),
    ('The Long Walk', 'Signet Books', '15 December 1978'),
    ('The Dead Zone', 'Viking Press', '15 August 1979'),
    ('Firestarter', 'Viking Press', '29 September 1980'),
    ('Cujo', 'Viking Press', '8 September 1981'),
    ('The Dark Tower: The Gunslinger', 'Grant', '10 June 1982'),
    ('Gösta Berlings saga','A. Bonniers','15 September 1950');

Insert into loans(personID,created,returndate,isReturned)
values
    (3,'1 January 2025','7 February 2025',true),
    (2,'1 March 2025','7 April 2025',true),
    (4,'2 March 2025','16 March 2025',true),
    (4,'1 April 2025','11 May 2025',true),
    (5,'1 April 2025','10 June 2025',true),
    (1,'9 June 2025','1 July 2025',true),
    (4,'1 August 2025','11 September 2025',true),
    (7,'16 August 2025','7 November 2025',true);

insert into loans(personID,created,returndate)
values
    (7,'30 September 2025',' 20 November 2025'),
    (2,'5 October 2025','10 December 2025'),
    (5,'1 November 2025','1 January 2026'),
    (3,'7 November 2025','1 January 2026');

insert into bookcopy(bookid,libraryid,booktype)
values
    (20,4,'ljudbok'),
    (1,2,'fysisk'),
    (11,2,'ljudbok'),
    (3,3,'fysisk'),
    (10,4,'fysisk'),
    (7,1,'fysisk'),
    (9,1,'fysisk'),
    (3,3,'fysisk'),
    (2,3,'fysisk'),
    (1,4,'ljudbok'),
    (6,4,'fysisk'),
    (19,3,'ljudbok'),
    (18,1,'fysisk'),
    (17,2,'ljudbok'),
    (16,1,'fysisk'),
    (15,3,'fysisk'),
    (14,2,'fysisk'),
    (13,3,'fysisk'),
    (12,1,'fysisk'),
    (11,1,'ljudbok');

insert into membership
values
    (1,2),
    (2,3),
    (3,1),
    (1,1),
    (1,3),
    (4,1),
    (5,1),
    (6,1),
    (7,1);

Insert into loanedcopies
values
    (1,1),
    (1,2),
    (2,8),
    (2,9),
    (3,10),
    (4,5),
    (4,6),
    (5,17),
    (6,11),
    (7,16),
    (8,1),
    (8,2),
    (8,3),
    (9,7),
    (10,11),
    (11,12),
    (12,15);

insert into categoryJunc
values
    (1,2),
    (1,3),
    (2,2),
    (2,3),
    (3,2),
    (3,3),
    (4,2),
    (4,3),
    (5,2),
    (5,3),
    (6,2),
    (6,3),
    (7,2),
    (7,3),
    (8,2),
    (8,3),
    (8,5),
    (9,2),
    (9,3),
    (9,5),
    (10,3),
    (10,6),
    (11,3),
    (11,6),
    (12,3),
    (12,6),
    (13,3),
    (13,6),
    (14,3),
    (14,6),
    (15,3),
    (15,6),
    (16,2),
    (16,4),
    (17,2),
    (17,4),
    (18,2),
    (18,4),
    (19,2),
    (19,4),
    (20,2),
    (20,3),
    (20,4),
    (21,1);

INSERT INTO authorJunc (bookID, authorID)
VALUES
    (1, 4),
    (2, 4),
    (3, 4),
    (4, 4),
    (5, 4),
    (6, 4),
    (7, 4),
    (8, 4),
    (9, 1),
    (10, 1),
    (11, 6),
    (12, 6),
    (13, 6),
    (14, 6),
    (15, 6),
    (16, 6),
    (17, 6),
    (18, 6),
    (19, 6),
    (20, 6),
    (21, 3);
