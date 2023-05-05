export interface IProduct {
  id: number;
  name?: string | null;
  price?: number | null;
  description?: string | null;
}

export type NewProduct = Omit<IProduct, 'id'> & { id: null };
