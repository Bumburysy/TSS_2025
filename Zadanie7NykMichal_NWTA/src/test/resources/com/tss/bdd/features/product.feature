Feature: Operacje CRUD na produktach w systemie

  Scenario: Dodanie nowego produktu
    Given użytkownik chce dodać produkt o nazwie "Testowy Produkt", cenie 99.99 i opisie "Nowy Produkt"
    When produkt zostanie dodany do systemu
    Then produkt powinien być dostępny do pobrania po ID
    And jego nazwa powinna być równa "Testowy Produkt"

  Scenario: Pobranie listy produktów
    Given istnieją produkty "Klawiatura" i "Słuchawki" i użytkownik chce zobaczyć produkty w bazie
    Then produkty powinieny być dostępne w bazie
    And powinno być co najmniej 2 produktów w systemie

  Scenario: Aktualizacja ceny produktu
    Given istnieje produkt o nazwie "Akutalizowany Produkt", cenie 150.69 i opisie "Stary Opis" a użytkownik zmienia cenę
    When użytkownik zmienia cenę produktu na 750.00
    Then cena produktu powinna wynosić 750.00

  Scenario: Usunięcie produktu
    Given istnieje produkt o nazwie "Usuwanu Produkt", cenie 21.37 i opisie "Opis" a użytkownik usuwa produkt
    When użytkownik usuwa produkt
    Then produkt nie powinien istnieć w systemie

  Scenario: Pobranie nieistniejącego produktu
    When użytkownik próbuje pobrać produkt o ID 10