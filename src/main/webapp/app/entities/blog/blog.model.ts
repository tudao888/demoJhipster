export interface IBlog {
  id: number;
  title?: string | null;
  content?: string | null;
  image?: string | null;
  imageContentType?: string | null;
}

export type NewBlog = Omit<IBlog, 'id'> & { id: null };
