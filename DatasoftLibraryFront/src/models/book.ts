import type { Genre } from "./genre";
import type { User } from "./user";

export interface Book {
    id: number;
    name: string;
    summary: string;
    price: number;
    state: string;
    image: string;
    genre: Genre | null;
    user: User | null;
}