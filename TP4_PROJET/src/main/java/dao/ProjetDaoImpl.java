	package dao;
	
	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.util.ArrayList;
	import java.util.List;
	
	import metier.SingletonConnection;
	import metier.entities.Projet;
	
	public class ProjetDaoImpl implements IProjetDao {
		@Override
		public Projet save(Projet p) {
			Connection conn = SingletonConnection.getConnection();
			try {
				PreparedStatement ps = conn.prepareStatement("INSERT INTO PROJETS(NOM_PROJET,COUT) VALUES(?,?)");
				ps.setString(1, p.getNomProjet());
				ps.setDouble(2, p.getCout());
				ps.executeUpdate();
				PreparedStatement ps2 = conn.prepareStatement("SELECT MAX(ID_PROJET) as MAX_ID FROM PROJETS");
				ResultSet rs = ps2.executeQuery();
				if (rs.next()) {
					p.setIdProjet(rs.getLong("MAX_ID"));
				}
				ps.close();
				ps2.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return p;
		}
		@Override
		public List<Projet> projetsParMC(String mc) {
			List<Projet> prods = new ArrayList<Projet>();
			Connection conn = SingletonConnection.getConnection();
			try {
				PreparedStatement ps = conn.prepareStatement("select * from PROJETS where NOM_PROJET LIKE ?");
				ps.setString(1, "%" + mc + "%");
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					Projet p = new Projet();
					p.setIdProjet(rs.getLong("ID_PROJET"));
					p.setNomProjet(rs.getString("NOM_PROJET"));
					p.setCout(rs.getDouble("COUT"));
					prods.add(p);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return prods;
		}
	
		@Override
		public Projet getProjet(Long id) {
		Connection conn=SingletonConnection.getConnection();
		 Projet p = new Projet();
		 try {
		PreparedStatement ps= conn.prepareStatement("select * from PROJETS where ID_PROJET = ?");
		ps.setLong(1, id);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
		p.setIdProjet(rs.getLong("ID_PROJET"));
		p.setNomProjet(rs.getString("NOM_PROJET"));
		p.setCout(rs.getDouble("COUT"));
		}
		} catch (SQLException e) {
		e.printStackTrace();
		}
		return p;
		}
	
		@Override
		public Projet updateProjet(Projet p) {
			Connection conn=SingletonConnection.getConnection();
			 try {
			PreparedStatement ps= conn.prepareStatement("UPDATE PROJETS SET NOM_PROJET=?,COUT=? WHERE ID_PROJET=?");
			ps.setString(1, p.getNomProjet());
			ps.setDouble(2, p.getCout());
			ps.setLong(3, p.getIdProjet());
			ps.executeUpdate();
			ps.close();
			} catch (SQLException e) {
			e.printStackTrace();
			}
			return p;
		}
	
		@Override
		public void deleteProjet(Long id) {
			Connection conn=SingletonConnection.getConnection();
			 try {
			PreparedStatement ps= conn.prepareStatement("DELETE FROM PROJETS WHERE ID_PROJET = ?");
			ps.setLong(1, id);
			ps.executeUpdate();
			ps.close();
			} catch (SQLException e) {
			e.printStackTrace();
			}
		}
	
	}
