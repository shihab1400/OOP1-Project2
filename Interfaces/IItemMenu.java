package Interfaces;
import Entity.*;

import java.util.Scanner;

public interface IItemMenu{
	void insert(Item f);
	Item getByCode(String code);
	void deleteByCode(String code);
	void searchByName(String name);
	void showAll();
}