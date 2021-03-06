package lab.io.rush.dao.impl;

import lab.io.rush.dao.SnapRecordDao;
import lab.io.rush.dao.datanucleus.dao.DataNucleusDao;
import lab.io.rush.pojo.SnapRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by cpt72 on 2016/12/11.
 */
@Repository
public class SnapRecordDaoImpl implements SnapRecordDao {
    @Autowired
    @Qualifier("dataNucleusDaoImpl")
    private DataNucleusDao dataNucleusDao;

    @Override
    public int insert(SnapRecord snapRecord) {
        return (int) dataNucleusDao.insert(snapRecord);
    }

    @Override
    public boolean update(SnapRecord snapRecord) {
        return dataNucleusDao.update(snapRecord);
    }

    @Override
    public SnapRecord selectById(int id) {
        return dataNucleusDao.selectByPrimaryKey(SnapRecord.class, id);
    }

    @Override
    public List<SnapRecord> selectByUid(int uid) {
        String query = "uid==" + uid;
        List<SnapRecord> snapRecords = dataNucleusDao.selectByQuery(SnapRecord.class, query);
        return snapRecords;
    }

    @Override
    public List<SnapRecord> selectByMovieId(int movieId) {
        String query = " movieId==" + movieId;
        List<SnapRecord> snapRecords = dataNucleusDao.selectByQuery(SnapRecord.class, query);
        return snapRecords;
    }

    @Override
    public SnapRecord selectByUidAndMovieId(int uid, int movieId) {
        String query = "uid==" + uid + " && movieId==" + movieId;
        List<SnapRecord> snapRecords = dataNucleusDao.selectByQuery(SnapRecord.class, query);
        if (snapRecords == null || snapRecords.isEmpty())
            return null;
        else
            return snapRecords.get(0);
    }
}
